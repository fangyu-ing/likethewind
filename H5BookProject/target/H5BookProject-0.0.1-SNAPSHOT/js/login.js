$(function(){
	
	//添加书籍
  $("#login_sub").click(function (){
      var name = $("#name").val();
      var pwd = $("#pwd").val();
      if(name==''||pwd==''){
    	  alert("请用户名和密码不能为空！"); 
	  }
      else{
      
      var date={
      	  name:name,pwd:pwd
      }
      var login=JSON.stringify(date)
       $.ajax({
           url: "/H5BookProject/login",
           type: "post",
           contentType: "application/json;charset=utf-8",
           data: login,
           dataType:"json",
           success: function (data) {
        	   if(!data){
				       alert("用户名或密码不正确！"); 
				}else{
					window.location.href="index.html";
				}
               
           },
           error: function (data) {
               alert('读者编号号已存在！');
           }  
       })
      }
   })
  
});