
/**
 * Grid.js
 * @author 研发部
 * 创建时间：2017-12-06 11:26
 * 类说明
 * 网格系统
*/
var Grid = function() {
	var local = this;

	local.arrRow = [];
	local.arrCol = [];

	local.rootEle = null;
	local.arrEle = [];
	local.arrChildGrid = [];
	local.gridMap = {};		//

	local.rowFreeCount = 0;
	local.rowFixedSize = 0;
	//local.rowFreePercent = 0;

	local.colFreeCount = 0;
	local.colFixedSize = 0;
	//local.colFreePercent = 0;

	local._init = function() {
		//local.init();
	};

	local.init = function(_rootEle, parentGrid, rootGrid) {
		parentGrid = (typeof (arguments[1]) === "undefined" ? null : parentGrid);
		rootGrid = (typeof (arguments[2]) === "undefined" ? local : rootGrid);
		//console.info(rootGrid, typeof (arguments[2]) === "undefined");

		local.rootEle = _rootEle;
		local.arrRow = [];
		local.arrCol = [];
		local.arrEle = [];
		local.arrChildGrid = [];
		local.gridMap = {};
		local.rowFreeCount = 0;
		local.rowFixedSize = 0;
		local.colFreeCount = 0;
		local.colFixedSize = 0;

		var isDefRow = false;
		var isDefCol = false;
		$(local.rootEle).children().each(function(idx, ele) {
			//var attrs = $(this).attr("grid");
			//if(attrs === undefined || attrs == "") {
			//	return;
			//}

			//row define
			if($(this).hasClass("gridRow")) {
				isDefRow = true;
				var arr = $(this).html().split(",");
				for(var i = 0; i < arr.length; ++i) {
					if(arr[i] == "" || arr[i] == "*") {
						arr[i] = "1*";
					}

					if(!local.isPercent(arr[i])) {
						local.rowFixedSize += Number(arr[i]);
					} else {
						local.rowFreeCount += local.getPercent(arr[i]);
						//++local.rowFreeCount;
					}

					local.arrRow.push(arr[i]);
				}
				return;
			}

			//col define
			if($(this).hasClass("gridCol")) {
				isDefCol = true;
				var arr = $(this).html().split(",");
				for(var i = 0; i < arr.length; ++i) {
					if(arr[i] == "" || arr[i] == "*") {
						arr[i] = "1*";
					}

					if(!local.isPercent(arr[i])) {
						local.colFixedSize += Number(arr[i]);
					} else {
						local.colFreeCount += local.getPercent(arr[i]);
						//++local.colFreeCount;
					}
					local.arrCol.push(arr[i]);
				}
				return;
			}


			var pGrid = parentGrid;
			if(local.arrRow.length != 0 && local.arrCol.length != 0) {
				pGrid = local;
			}

			//child grid
			var grid = new Grid();
			grid.init(this, pGrid, rootGrid);
			if(grid.arrRow.length != 0 && grid.arrCol.length != 0) {
				var id = $(this).attr("id");
				//console.info(this, rootGrid, $(this).attr("id"));
				if(id == "" || typeof(id) === "undefined") {
					id = $(this).attr("class");
				}
				if(id != "" && typeof (id) !== "undefined" && !(id in rootGrid.gridMap)) {
					rootGrid.gridMap[id] = grid;
				}
				pGrid.arrChildGrid.push(grid);
			}

			if(local.arrRow.length == 0 || local.arrCol.length == 0) {
				return;
			}

			var attrs = $(this).attr("grid");
			if(attrs === undefined || attrs == "") {
				//return;
			} else {
				local.arrEle.push(this);
			}
		});



		//if(local.arrRow.length != 0) {
		//	console.info(local.arrRow, local.arrCol, local.arrChildGrid);
		//}

		//if(local.arrRow.length != 0 && local.arrCol.length != 0) {
		//	local.update();
		//}
	};

	local.findGrid = function(id) {
		if(id in local.gridMap) {
			return local.gridMap[id];
		} else {
			return null;
		}
	};

	local.setRow = function(idx, value) {
		value = "" + value;
		if(value == "" || value == "*") {
			value = "1*";
		}

		var oldVal = local.arrRow[idx];
		local.arrRow[idx] = value;

		if(local.isPercent(oldVal)) {
			local.rowFixedSize -= local.getPercent(oldVal);
		} else {
			local.rowFixedSize -= Number(oldVal);
		}

		if(local.isPercent(value)) {
			local.rowFixedSize += local.getPercent(value);
		} else {
			local.rowFixedSize += Number(value);
		}

		var rowVal = local.arrRow.join(",");
		$(local.rootEle).find(".gridRow").html(rowVal);

		local.update();
	};

	local.setCol = function(idx, value) {
		value = "" + value;
		if(value == "" || value == "*") {
			value = "1*";
		}

		var oldVal = local.arrCol[idx];
		local.arrCol[idx] = value;

		if(local.isPercent(oldVal)) {
			local.colFixedSize -= local.getPercent(oldVal);
		} else {
			local.colFixedSize -= Number(oldVal);
		}

		if(local.isPercent(value)) {
			local.colFixedSize += local.getPercent(value);
		} else {
			local.colFixedSize += Number(value);
		}

		var colVal = local.arrCol.join(",");
		$(local.rootEle).find(".gridCol").html(colVal);

		local.update();
	};

	local.setEle = function(ele) {

	};

	local.update = function() {
		if(local.arrRow.length == 0 || local.arrCol.length == 0) {
			return;
		}

		//console.info(local.arrRow, local.arrCol, local.arrChildGrid, local.arrEle);

		//var width = $(local.rootEle).width();
		//var height = $(local.rootEle).height();

		//console.info($(local.rootEle).css("margin-top"));

		for(var i = 0; i < local.arrEle.length; ++i) {
			var arrAttr = $(local.arrEle[i]).attr("grid").split(",");
			if(arrAttr.length == 2) {
				arrAttr.push(1);
				arrAttr.push(1);
			}
			if(arrAttr.length == 4) {
				//return;
			} else {
				return;
			}

			//var ml = $(local.arrEle[i]).css("margin-left");
			//ml = ml.substr(0, ml.length - 2);
			var ml = local.getMargin(local.arrEle[i], "margin-left");
			var mr = local.getMargin(local.arrEle[i], "margin-right");
			var mt = local.getMargin(local.arrEle[i], "margin-top");
			var mb = local.getMargin(local.arrEle[i], "margin-bottom");
			//console.info(ml, mr);

			//console.info(Number($(local.arrEle[i]).css("margin-top")));

			var row = Number(arrAttr[0]);
			var col = Number(arrAttr[1]);
			var rowNum = Number(arrAttr[2]);
			var colNum = Number(arrAttr[3]);

			//console.info(row, col, rowNum, colNum);

			var eleLeft = local.getLeft(col);
			var eleTop = local.getTop(row);
			var eleHeight = local.getRowSize(row, rowNum) - (mt + mb);
			var eleWidth = local.getColSize(col, colNum) - (ml + mr);
			//console.info(eleWidth, eleHeight, mt, mb, local.arrEle[i]);

			$(local.arrEle[i]).css("left", eleLeft + "px");
			$(local.arrEle[i]).css("top", eleTop + "px");
			$(local.arrEle[i]).css("height", eleHeight + "px");
			$(local.arrEle[i]).css("width", eleWidth + "px");
			//console.info(eleLeft, eleTop, eleWidth, eleHeight);
			//console.info($(local.arrEle[i]).width());
			//console.info($(local.arrEle[i]).attr("class"));
		};

		for(var i = 0; i < local.arrChildGrid.length; ++i) {
			local.arrChildGrid[i].update();
		}

		//$(local.rootEle).children().each(function(idx, ele) {
		//	local.arrChildGrid
		//});
	};

	local.getLeft = function(idx) {
		return local.getColSize(0, idx);
	};

	local.getMargin = function(ele, text) {
		var rst = $(ele).css(text);
		rst = rst.substr(0, rst.length - 2);

		return Number(rst);
	};

	local.getTop = function(idx) {
		return local.getRowSize(0, idx);
	};

	local.getRowSize = function(idx, num) {
		var height = $(local.rootEle).height();

		var rst = 0;
		for(var i = idx; i < idx + num; ++i) {
			var data = local.arrRow[i];
			//console.info(i, idx, num, data, local.arrRow, local.rootEle);
			
			if(local.isPercent(data)) {
				var perNum = local.getPercent(data);
				//console.info("aa", num, local.rowFreeCount, height, local.rowFixedSize);
				rst += perNum / local.rowFreeCount * (height - local.rowFixedSize);
			} else {
				rst += Number(data);
			}
		}
		return rst;
	};

	local.getColSize = function(idx, num) {
		var width = $(local.rootEle).width();

		var rst = 0;
		for(var i = idx; i < idx + num; ++i) {
			var data = local.arrCol[i];

			if(local.isPercent(data)) {
				var perNum = local.getPercent(data);
				rst += perNum / local.colFreeCount * (width - local.colFixedSize);
			} else {
				rst += Number(data);
			}
		}
		return rst;
	};

	local.isPercent = function(data) {
		//try {
		//	data.charAt(data.length - 1) == "*"
		//} catch(ex) {
		//	console.info("ss", data);
		//	console.info(local.arrRow, local.arrCol, local.arrChildGrid);
		//}
		return data.charAt(data.length - 1) == "*";
	};

	local.getPercent = function(data) {
		return Number(data.substr(0, data.length - 1));
	};

	local.resize = function() {
		//console.info("resize");
		local.update();
	};

	//init
	local._init();
};




	
	


