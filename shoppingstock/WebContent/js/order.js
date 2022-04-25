$(function(){
	$.ajax({
		type:"POST",
		url:"/20191029-Demo/OrderServlet",
		dataType:"json",
		success:function(result){
			$("#tbo").find("tr").remove();
			var date=null;
			$(result).each(function(i,e){
				date = e.orderdate;
				var nian=date.year+1900;
				var yue=date.month+1;
				var ri=date.date;
				var hour = date.hours;
				var minute = date.minutes; 
				$("#tbo").append(
						"<tr><td>"+e.orderid+"</td><td>"+e.orderflag+"</td><td>"+nian+"-"+yue+"-"+ri+"<br>"+hour+":"+minute+"</td><td >"+e.memberid+"</td><td>"+e.stat+"</td><td>"+e.note+"</td></tr>");

			})
		}
	})
})