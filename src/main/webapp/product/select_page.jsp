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

<h3>��Ƭd��:</h3>
<%-- ���~��C --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">�Эץ��H�U���~:</font>
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
        <b>��J�ӫ~�s��:</b>
        <input type="text" name="productId">
        <input type="hidden" name="action" value="getOne_For_Display">
        <input type="submit" value="�e�X">
    </FORM>
  </li>

  <jsp:useBean id="productService" scope="page" class="com.product.model.ProductService" />
  
<!--   ��"com.emp.model.EmpDAO"�Ыؤ@��dao���ۤv�ݱo�쪺���� �PforEach���t-->
<%-- ���� <% com.emp.model.EmpDAO dao2 = new com.emp.model.EmpDAO(); %> <% pageContext.setAttribute("dao1", dao2); %> <!-- P204 337 --> --%>
   
  <li>
     <FORM METHOD="post" ACTION="product.do" >
       <b>��ܰӫ~�s��:</b>
       <select size="1" name="productId">
          <c:forEach var="productVO" items="${productService.all}" >  <%--${pageScope.dao1.getall} P236 ���̦n�ϥζ��ئW��var="empVO" --%>
          <option value="${productVO.productId}">${productVO.productId}  <%-- ���쪺�ȡ�"${empVO1.empno}"�����ݨ쪺��${empVO1.empno} --%>
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="�e�X">
    </FORM>
  </li>
  
  <li>
     <FORM METHOD="post" ACTION="product.do" >
       <b>��ܰӫ~�W��:</b>
       <select size="1" name="productId">
         <c:forEach var="productVO" items="${productService.all}" > 
          <option value="${productVO.productId}">${productVO.name}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="�e�X">
     </FORM>
  </li>
</ul>

<h3>�ӫ~�ؿ�</h3>

<ul>
  <li><a href='addProduct.jsp'>�s�W</a>�ӫ~</li>
</ul>

<script>    
   function fun1(){
      with(document.form1){
         if (productId.value=="") 
             alert("�п�J�ӫ~�s��!");
         else if (isNaN(productId.value)) 
             alert("�ӫ~�s���榡�����T!");
         else if (productId.value > 10 ) 
             alert("�|�L���ӫ~�s��");
         else
             submit();
      }
   }
</script>

</body>
</html>