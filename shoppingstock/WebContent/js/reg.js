$(function(){
	//注册判断 
	$("#reg").click(function(){
		var regaccount = $("#regaccount").val();
//		alert(regaccount);
		var regpassword = $("#regpassword").val();
//		alert(regpassword);
		var regpwd = $("#regpwd").val();
//		alert(repwd);
//		alert("测试");
		$.ajax({
			type:"POST",
			url:"/20191029-Demo/SuccessServlet",
			data:{"regaccount":regaccount,
				  "regpassword":regpassword
			},
			success:function(result){
				console.log(result);
				if(result =="OK"){
					alert("注册成功,可以使用此账号登录了");
					$("#loginsDiv").css("display","block");
					$("#regsDiv").css("display","none");
			     }else{
			    	 alert("注册失败,请重新注册");
			    	 $("#regaccount").val("");		    	 
			    	 $("#regpassword").val("");		    	 
			    	 $("#regpwd").val("");		    	 
			     }
			}
		});
	});

	// 判断用户名是否存在
	 $("#regaccount").blur(function(){
	    	var regaccount = $("#regaccount").val();
	    		$.ajax({
	        	type:"POST",
	    		url:"/20191029-Demo/RegServlet",
	    		data:{"regaccount":regaccount},
	    		success:function(result){
	    			console.log(result)
	    			if(result == "Not" || result== ""){
	    				$("#span1").css("color","yellow").html("此用户名已存在")
	    			}else{
	    				$("#span1").css("color","yellow").html("此用户名可以使用")
	    			}
	    		}
	        });
	    	
	    });
	  // 验证密码是否一致
	 $("#regpwd").blur(function(){
	    	var password = $("#regpassword").val();
	    	var pwd = $("#regpwd").val();
	    	if(password == pwd){
	    		$("#span2").css("color","yellow").html("两次密码一致")
	    	}else{
	    		$("#span2").css("color","yellow").html("两次密码不一致,请重新输入")
	    	}
	    });
	 
	// 登录验证用户名和密码是否匹配 用户名是否存在
		// 登录成功跳转界面
		$("#login").click(function(){
			var account = $("#loginaccount").val();
			var password = $("#loginpassword").val();
//			alert(account)
			$.ajax({
				type:"POST",
	    		url:"/20191029-Demo/LoginServlet",
	    		data:{"account":account,
	    		      "password":password	
	    		},
	    		success:function(result){
	    			if(result == "error"){
	    				$("#span3").css("color","yellow").html("用户名或密码错误")
	    			}else{
	    				location.href = "index.html";
	    			}
	    		}
			})
		});
});
