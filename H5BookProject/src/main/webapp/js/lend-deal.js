$(function(){
	
	//借书
  $("#btn_lend").click(function (){
	  
      var bookId = $("#bookId").val();
      var userId = $("#userId").val();
      //alert(bookId+userId);
      if(bookId==''||userId==''){
    	  alert("请输入书号和读者编号"); 
	  }
      else{
      var date = new Date();
      var seperator1 = "-";
      var year = date.getFullYear();
      var month = date.getMonth() + 1;
      var strDate = date.getDate();
      if (month >= 1 && month <= 9) {
          month = "0" + month;
      }
      if (strDate >= 0 && strDate <= 9) {
          strDate = "0" + strDate;
      }
      var lendDate = year + seperator1 + month + seperator1 + strDate;
      if(parseInt(month)==12){
    	  year=parseInt(year)+1;
    	  month=1;
      }
      var returnDate=year + seperator1 + (parseInt(month)+1) + seperator1 + strDate;
      var isReturn="否";
      var date={
      	  bookId: bookId, userId: userId,
      	lendDate: lendDate, returnDate: returnDate, isReturn: isReturn
      }
      var info=JSON.stringify(date)
       $.ajax({
           url: "/H5BookProject/lend/lendBook",
           type: "post",
           contentType: "application/json;charset=utf-8",
           data: info,
           dataType:"json",
           success: function (data) {
        	   var str = data.result;
        	  // alert(str);
        	   if(str=="success"){
        		   alert("借书成功！"); 
        	   $("#tb_lendManage").bootstrapTable('refresh'); 
        	   }
				else{
				 alert("此书库存不足，无法借阅！"); 
				 
				}              
           },          
       })
      }
   })
});