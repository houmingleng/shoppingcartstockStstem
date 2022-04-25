 //后台登录后， 界面显示用户真实姓名和籍贯
$(function(){
	$.ajax({
		type:"POST",
		url:"/20191029-Demo/ConterlServlet",
		dataType:"json",
		success:function(result){
			$(result).each(function(i,e){
				 $("#pac1").text(e.realname);
				 $("#pac2").text(e.realname);
				 $("#pplace").text(e.place);
			})
		}
	})
})