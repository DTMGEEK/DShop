function getlogoinfo() {
	
        
        var usernames = $("#username").val();
        var passwords = $("#password").val();

        
        
        
        
   if(checkPasswordEmp()&&checkPasswordEmp()){
        
      $("#logoform").submit();
        
   }
}




function checkUsernameEmp(){
	
	var username = $("#username").val();
	
	
	if(!username){
		
		
		$("#fusername").text("用户名不能为空");
		return false;
	
	}else{
		
		$("#fusername").text("");
		
		return true;
	}
	
	
	
}


function checkPasswordEmp(){
	
	var password = $("#password").val();
	
	if(!password){
		
		
		$("#fpassword").text("密码不能为空");
		
		return false;
	
	}else{
		
		$("#fpassword").text("");
		
		return true;
	}
	
}


function checkNlEmp(){
	
	var nl = $("#nl").val();
	 
	if(!nl){
		
		$("#fnl").text("验证码不能为空");
	
	}else{
		
		$("#fnl").text("");
		
		
	}
	
}