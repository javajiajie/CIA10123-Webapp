<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Product: Home</title>
<style>
  table#table-1 {
	width: 450px;
	background-color: #CCCCFF;
	margin-top: 5px;
	margin-bottom: 10px;
    border: 3px ridge Gray;
    height: 80px;
    text-align: center;
  }
  table#table-1 h4 {
    color: red;
    display: block;
    margin-bottom: 1px;
  }
  h4 {
    color: blue;
    display: inline;
  }
</style>
</head>
<body>

<table id="table-1">
   <tr><td><h3>Product: Home</h3><h4>( MVC )</h4></td></tr>
</table>

<p>This is the Home page for MMDFProduct: Home</p>

<h3>資料查詢:</h3>
<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<ul>
  <li><a href='listAllProduct_byDAO.jsp'>List</a> all Products    <h4>
 	 </h4></li>

  
  <li>
    <FORM METHOD="post" ACTION="product.do" >
        <b>輸入商品編號:</b>
        <input type="text" name="productId">
        <input type="hidden" name="action" value="getOne_For_Display">
        <input type="submit" value="送出">
    </FORM>
  </li>

  <jsp:useBean id="productService" scope="page" class="com.product.model.ProductService" />
  
<!--   用"com.emp.model.EmpDAO"創建一個dao的自己看得到的物件 與forEach絕配-->
<%-- ↑↑ <% com.emp.model.EmpDAO dao2 = new com.emp.model.EmpDAO(); %> <% pageContext.setAttribute("dao1", dao2); %> <!-- P204 337 --> --%>
   
  <li>
     <FORM METHOD="post" ACTION="product.do" >
       <b>選擇商品編號:</b>
       <select size="1" name="productId">
          <c:forEach var="productVO" items="${productService.all}" >  <%--${pageScope.dao1.getall} P236 →最好使用項目名稱var="empVO" --%>
          <option value="${productVO.productId}">${productVO.productId}  <%-- 取到的值→"${empVO1.empno}"眼睛看到的→${empVO1.empno} --%>
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="送出">
    </FORM>
  </li>
  
  <li>
     <FORM METHOD="post" ACTION="product.do" >
       <b>選擇商品名稱:</b>
       <select size="1" name="productId">
         <c:forEach var="productVO" items="${productService.all}" > 
          <option value="${productVO.productId}">${productVO.name}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="送出">
     </FORM>
  </li>
</ul>

<h3>商品目錄</h3>

<ul>
  <li><a href='addProduct.jsp'>新增</a>商品</li>
</ul>

<script>    
   function fun1(){
      with(document.form1){
         if (productId.value=="") 
             alert("請輸入商品編號!");
         else if (isNaN(productId.value)) 
             alert("商品編號格式不正確!");
         else if (productId.value > 10 ) 
             alert("尚無此商品編號");
         else
             submit();
      }
   }
</script>

</body>
</html>