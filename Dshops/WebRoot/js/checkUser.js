
/*用户注册校验*/


   var jfalg=false; 
   var jlength=false;
   var jplength=false;
   var jmail=false;
   
function getinfo(){

	
	var val=$("#cusername").val();
   
	if(val.length==0){
		
		 $("#checkResult").html("用户名不能为空");
		
		return false;
	}
	
   if(val.length<5){
	   
	   $("#checkResult").html("用户名必须长于5位");
	   jlength=false;
	   
	   return false;
	   
	   
   }else{
	   
	   jlength=true;
	   $("#checkResult").html("");
   }
   
  
   
   $.post(
		   "/test/json.action",  
		   {"userName":val},  
		   function(result){
			   
			   if(val.length<5){
				   
				   $("#checkResult").html("用户名必须长于5位");
				   jlength=false;
				   
				   return false; 
			   }
			      
			   if(!result.flag){
				   
				   $("#checkResult").html("该用户名可以使用");
				   jfalg=true;
				   
			   }else{
				   
				   jfalg=false;
				   $("#checkResult").html("该用户名已经被使用请重新输入");
				   
				   
			   }
			   
		   },
		   "json"
   
   )
   
}

function checkPasswordLength(){
	
	var password=$("#password").val();
	
	if(password.length==0){
		
		$("#checklength").html("密码不能为空");
		
		return false;
		
	}
	
	
	reg=/^[a-zA-Z]\w{5,17}$/;
	if(!reg.test(password)){
		
		$("#checklength").html("输入的密码不符合规定 ，请重新输入");
		jplength=false;
		
		return false;
		
		
	}else{
		
		jplength=true;

		$("#checklength").html("");
		
	}
	
}



function checkPassword(){
	
	var password=$("#password").val();
	var repassword=$("#repassword").val();
	
	if(password!=repassword)
	{
		$("#HackBox").html("两次输入密码不一致，请重新输入");
		
	}else{
		
		$("#HackBox").html("");
		
	}
	
	
}


function checkEmail(){
	

	/*1. 必须包含一个并且只有一个符号“@”
	2. 第一个字符不得是“@”或者“.”
	3. 不允许出现“@.”或者.@
	4. 结尾不得是字符“@”或者“.”
	5. 允许“@”前的字符中出现“＋”
	6. 不允许“＋”在最前面，或者“＋@”*/
	
	var email=$("#email").val();
	
	if(email.length==0){

		$("#checkEmail").html("邮箱不能为空");
		
		return false;
		
		
	}
	
	
	regs=/^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	
	if(!regs.test(email)){
		
		$("#checkEmail").html("邮件地址不符合规范请重新输入");
		jmail=false;
		
		
	}else{
		
		jmail=true;
		$("#checkEmail").html("");
		
		
	}
	
	
	
}



function checkForm(){
	
	
	if(!jfalg||!jfalg){
		
		this.getinfo();
		return false;
		
	}if(!jplength){
		
		this.checkPasswordLength();
		return false;
		
	}if(!jmail){
		
		this.checkEmail();
		return false;
		
	}
	
	
	
	return true;
	
}


