var pageNum=null;
var pageSize=null;
$(function() {
	ajax();
	
	
	$("#jia").click(function() {
		$("#tbo").find("tr").remove();
		pageNum+=1;
		if(pageNum >= pageSize)
			pageNum = pageSize -1;
		ajax();
	});
	$("#jian").click(function() {
		$("#tbo").empty();
		pageNum-=1;
		if(pageNum<1){
			pageNum=1;
		}
		ajax();
	});
	$("#qd").click(function() {
		$("#tbo").empty();
		// 文本框输入的值
		var v= $(".jump").val();
		pageNum = v;
		if(v <1){
			pageNum = 1;
		}
		if(v>3){
			pageNum = 3;
		}
		$(".jump").val(pageNum);
		ajax();
	});
});



function ajax() {
	$.ajax({
		type:"POST",
		url:"/20191029-Demo/FenYeServlet",
		data:{
			"pageNum":pageNum,
			"pageSize":pageSize,
			},
		success:function(result){
			var date=null;
			$(result).each(function(i,e) {
				if(i==0){
					$(e.lists).each(function(j,p) {
						var tui = '已推送';
						var tuipic='push push01';
						if(p.stat==0){
							tui = '未推送';
							tuipic='push push02';
						}
					date=p.makedate;
					var nian=date.year+1900;
					var yue=date.month+1;
					var ri=date.date;
					var hour = date.hours;
					var minute = date.minutes; 
					console.log(date);
						$("#tbo").append(
								"<tr><td>"+p.goodsid+"</td><td><a>"+p.name+"</a></td><td>"+p.spflag+"</td><td class='edit'><span>"+p.note+"</span> <imgsrc='img/edit.png' ></td><td>"+nian+"-"+yue+"-"+ri+"<br>"+hour+":"+minute+"	</td><td><span class='del'>"+p.price+"</span></td><td>"+p.amount+"</td><td><span id='tuisong' class='"+tuipic+"'>"+tui+"</span></td></tr>");
					})
//					console.log(e.lists);
//					console.log(e);
					$("#inp").val(e.pageCount);
					pageNum = e.pageNum;
//					alert(pageNum);
					pageSize=e.pageSize;
					//console.log(pageNum);
					//console.log(pageSize);
				}
			})
		},
		dataType:"json"
	});
}