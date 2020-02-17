$(function(){
	//添加书籍
  $("#add").click(function (){
      var bookId = $("#bookId").val();
      var bookName = $("#bookName").val();
      var writer = $("#writer").val();
      var publisher = $("#publisher").val();
      var price = $("#price").val();
      var stock = $("#stock").val();
      var type = $("#type").val();
      var data={
      	  bookId: bookId, bookName: bookName, writer: writer,
          publisher: publisher, price: price, stock: stock,
          type: type
      }
      var info=JSON.stringify(data);
      if(bookId==''){
    	  $("#bid").text('书号不能为空!');
    	  }
      if(bookName==''){
    	  $("#bname").text('书名不能为空!');
    	  }
      else(
      
       $.ajax({
           url: "/H5BookProject/book/addBook",
           type: "post",
           contentType: "application/json;charset=utf-8",
           data: info,
           dataType:"json",
           success: function (data) {
        	   $('#addModal').modal('hide');
        	   $("#tb_books").bootstrapTable('refresh');
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
               alert('书号已存在！');
           }  
       })
       )
   })
   //删除书籍
	$("#btn_delete").click(function () {
		         //获取当前选择行id
		         var selectedRows = $("#tb_books").bootstrapTable('getSelections');
		         if (selectedRows.length <= 0) {
		             alert('请选择要删除的数据');
		             return;
		         }
		         var ids = '';
		         for (var i = 0; i < selectedRows.length; i++) {
		             ids += selectedRows[i]['bookId'] + ",";
		         }
		         ids = ids.substring(0, ids.length - 1);
		         var msg = "您真的确定要删除吗？";
		         if (confirm(msg) == true) {
		         $.ajax({
		             url: '/H5BookProject/book/deleteBook',
		             type: 'get',
		             contentType: 'application/json;charset=utf-8',
		             data: { bookId: ids },
		            success: function (data) {
                    $("#tb_books").bootstrapTable('refresh');
		             },
		             error: function (data) {
		                 alert('数据删除失败' + data);
		             }
		         })
		         }
		     })
	  
		     
	//查询书籍
 $("#typeSelect").change(function() {
	var value= $("#typeSelect").val();//获取当前选择项的值.
	 var options=$("#typeSelect option:selected");//获取当前选择项. 
	 var type=options.text();
	 $.ajax({
         url: "/H5BookProject/book/searchByType",
         type: "get",
         contentType: "application/json;charset=utf-8",
         data: { type: type},
         dataType:"json",
         success: function (data) {
        			 $("#tb_books").bootstrapTable('load',data);
        		 },
         error: function (data) {
             alert('查询数据失败' + data);
         }
     })
    });
  
  $("#btn_query").click(function() {
	     var bookName = $("#txt_search_statu").val();
		 var options=$("#typeSelect option:selected");//获取当前选择项. 
		 var type=options.text();
		 $.ajax({
	         url: "/H5BookProject/book/search",
	         type: "get",
	         contentType: "application/json;charset=utf-8",
	         data: { type:type,bookName:bookName},
	         dataType:"json",
	         success: function (data) {
	        			 $("#tb_books").bootstrapTable('load',data);
	        		 },
	  
	         error: function (data) {
	             alert('添加数据失败' + data);
	         }
	     })
	    });

	//修改书籍
	$("#btn_edit").click(function () {
         //获取当前选择行id
         var selectedRows = $("#tb_books").bootstrapTable('getSelections');
         if (selectedRows.length <= 0) {
             alert('请选择要编辑的数据');
         } 
         if (selectedRows.length > 1) {
            alert('一次只能选择一行数据进行编辑');
         } 
         if(selectedRows.length == 1){
        var bookId=selectedRows[0].bookId;
        var bookName=selectedRows[0].bookName;
        var writer=selectedRows[0].writer;
        var publisher=selectedRows[0].publisher;
        var price=selectedRows[0].price;
        var stock=selectedRows[0].stock;
        var type=selectedRows[0].type;
        	 $('#bookId1').val(bookId);
             $('#bookName1').val(bookName);
             $('#writer1').val(writer);
             $('#publisher1').val(publisher);
             $('#price1').val(price);
             $('#stock1').val(stock);
             $('#type1').val(type);
             $('#editModal').modal('show');
         }
                  
	})
	$("#edit").click(function (){
      var bookId = $("#bookId1").val();
      var bookName = $("#bookName1").val();
      var writer = $("#writer1").val();
      var publisher = $("#publisher1").val();
      var price = $("#price1").val();
      var stock = $("#stock1").val();
      var type = $("#type1").val();
      var date={
      	  bookId: bookId, bookName: bookName, writer: writer,
            publisher: publisher, price: price, stock: stock,
             type: type
      }
      var info=JSON.stringify(date)
       $.ajax({
           url: "/H5BookProject/book/editBook",
           type: "post",
           contentType: "application/json;charset=utf-8",
           data: info,
           dataType:"json",
           success: function (data) {
        	   $("#tb_books").bootstrapTable('refresh');
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