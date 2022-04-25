$(function(){
	$.ajax({
		type:"POST",
		url:"/20191029-Demo/Ds_memberServlet",
		dataType:"json",
		success:function(result){
			$("#tbo").find("tr").remove();
			var date=null;
			$(result).each(function(i,e){
				date = e.regdate;
				var nian=date.year+1900;
				var yue=date.month+1;
				var ri=date.date;
				var hour = date.hours;
				var minute = date.minutes; 
				$("#tbo").append(
						"<tr><td>"+e.memberid+"</td><td>"+e.account+"</td><td>"+e.logpwd+"</td><td>"+e.sex+"</td><td >"+e.realname+"</td><td>"+e.mobile+"</td><td>"+nian+"-"+yue+"-"+ri+"<br>"+hour+":"+minute+"</td><td>"+e.place+"</td><td>"+e.stat+"</td><td>"+e.score+"</td><td>"+e.note+"</td></tr>");

			})
		}
	})
})