$(function(){
	//添加书籍
  $("#add").click(function (){
      var userName = $("#userName").val();
      var dept = $("#dept").val();
      var grade = $("#grade").val();
      var tel = $("#tel").val();
      var address = $("#address").val();
      var date={
      	  userName: userName, dept: dept,
          grade: grade, tel: tel, address: address
      }
      var info=JSON.stringify(date)
      if(userName==''){
    	  $("#uname").text('姓名不能为空!');
    	  }
      else(
      
       $.ajax({
           url: "/H5BookProject/user/addUser",
           type: "post",
           contentType: "application/json;charset=utf-8",
           data: info,
           dataType:"json",
           success: function (data) {
        	 //  $('#addModal') .removeData('bs.modal');
        	   $('#addModal').modal('hide');
        	   
        	   $("#tb_users").bootstrapTable('refresh');
//          	 $.ajax({
//          		 url:"/H5BookProject/book/queryBooks",
//          		 dataType:"json",
//          		 success(data){
//          			 $("#tb_departments").bootstrapTable('load',data);
//          		 },
//          		 error(){
//          			 
//          		 },
//          	 })
               
           },
           error: function (data) {
               alert('读者编号号已存在！');
           }  
       })
       )
   })
   //删除书籍
	$("#btn_delete").click(function () {
		         //获取当前选择行id
		         var selectedRows = $("#tb_users").bootstrapTable('getSelections');
		         if (selectedRows.length <= 0) {
		             alert('请选择要删除的数据');
		             return;
		         }
		         var ids = '';
		         for (var i = 0; i < selectedRows.length; i++) {
		             ids += selectedRows[i]['userId'] + ",";
		         }
		         ids = ids.substring(0, ids.length - 1);
		         var msg = "您真的确定要删除吗？";
		         if (confirm(msg) == true) {
		         $.ajax({
		             url: '/H5BookProject/user/deleteUser',
		             type: 'get',
		             contentType: 'application/json;charset=utf-8',
		             data: { userId: ids },
		            success: function (data) {
                    $("#tb_users").bootstrapTable('refresh');
		             },
		             error: function (data) {
		                 alert('数据删除失败' + data);
		             }
		         })
		         }
		     })
	  
	//修改书籍
	$("#btn_edit").click(function () {
         //获取当前选择行id
         var selectedRows = $("#tb_users").bootstrapTable('getSelections');
         if (selectedRows.length <= 0) {
             alert('请选择要编辑的数据');
         } 
         if (selectedRows.length > 1) {
            alert('一次只能选择一行数据进行编辑');
         } 
         if(selectedRows.length == 1){
        var userId=selectedRows[0].userId;
        alert(userId);
        var userName=selectedRows[0].userName;
        var dept=selectedRows[0].dept;
        var grade=selectedRows[0].grade;
        var tel=selectedRows[0].tel;
        var address=selectedRows[0].address;
        	 $('#userId1').val(userId);
             $('#userName1').val(userName);
             $('#dept1').val(dept);
             $('#grade1').val(grade);
             $('#tel1').val(tel);
             $('#address1').val(address);
             $('#editModal').modal('show');
         }
                  
	})
	$("#edit").click(function (){
      var userId = $("#userId1").val();
      var userName = $("#userName1").val();
      var dept = $("#dept1").val();
      var grade = $("#grade1").val();
      var tel = $("#tel1").val();
      var address = $("#address1").val();
     
      var date={
      	 userId: userId, userName: userName, dept: dept,
            grade: grade, tel: tel, address: address
            
      }
      var info=JSON.stringify(date)
       $.ajax({
           url: "/H5BookProject/user/editUser",
           type: "post",
           contentType: "application/json;charset=utf-8",
           data: info,
           dataType:"json",
           success: function (data) {
        	   $('#editModal').modal('hide');
        	   $("#tb_users").bootstrapTable('refresh');
//          	 $.ajax({
//          		 url:"/H5BookProject/book/queryBooks",
//          		 dataType:"json",
//          		 success(data){
//          			 $("#tb_departments").bootstrapTable('load',data);
//          		 },
//          		 error(){
//          			 
//          		 },
//          	 })
          	 
               
           },
           error: function (data) {
          
               alert('添加数据失败' + data);
           }
       })
   })
});