$(function(){
	$.ajax({
		type:"POST",
		url:"/20191029-Demo/OrderdetailServlet",
		dataType:"json",
		success:function(result){
			$("#tbo").find("tr").remove();
			$(result).each(function(i,e){
				$("#tbo").append(
						"<tr><td>"+e.detailid+"</td><td>"+e.orderflag+"</td><td>"+e.spflag+"</td><td >"+e.salecount+"</td><td>"+e.stat+"</td><td>"+e.disct+"</td><td>"+e.note+"</td></tr>");

			})
		}
	})
})