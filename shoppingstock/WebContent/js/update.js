//修改个人信息的js
 //后台登录后， 基本设置显示用户个人信息
$(function(){
	$.ajax({
		type:"POST",
		url:"/20191029-Demo/ConterlServlet",
		dataType:"json",
		success:function(result){
			$(result).each(function(i,e){
				$("#inp1").val(e.memberid);
				$("#inp2").val(e.account);
				$("#inp3").val(e.sex);
				$("#inp4").val(e.realname);
				$("#inp5").val(e.mobile);
				$("#inp6").val(e.place);
				$("#inp7").val(e.stat);
				$("#inp8").val(e.score);
				$("#inp9").val(e.note);
			
	})
		}
});

	$("#tbo input").blur(function(){
		   var memberid = $("#inp1").val();
		   var account = $("#inp2").val();
		   var sex = $("#inp3").val();
		   var realname = $("#inp4").val();
		   var mobile = $("#inp5").val();
		   var place = $("#inp6").val();
		   var note = $("#inp9").val();
		   $.ajax({
			   type:"POST",
			   url:"/20191029-Demo/UpdateServlet",
			   dataType:"json",
			   data:{"memberid":memberid,
				     "account":account,
				     "sex":sex,
				     "realname":realname,
				     "mobile":mobile,
				     "place":place,
				     "note":note
			         },
		       success:function(result){
		    	   console.log(result);
		    	   $(result).each(function(i,e){
		           $("#inp1").val(e.memberid);
		           alert(e.memberid);
			       $("#inp3").val(e.sex);
				   $("#inp4").val(e.realname);
				   $("#inp5").val(e.mobile);
				   $("#inp6").val(e.place);
				   $("#inp9").val(e.note);
				   location.href = "update.html";
		    	   })
		       }
		   })
	});
});










