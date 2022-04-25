$(function(){
	$.ajax({
		type:"POST",
		url:"/20191029-Demo/AddressServlet",
		dataType:"json",
		success:function(result){
			$(result).each(function(i,e){
				console.log(e);
				$("#tbo").find("tr").remove();
				$("#tadd").append(
						"<tr><td>"+e.addrid+"</td><td>"+e.memberid+"</td><td>"+e.address+"</td><td>"+e.zip+"</td><td>"+e.stat+"	</td><td>"+e.note+"</td></tr>");
			})
		}
	})
	
})