<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="BIG5"%>
<%@ page import="com.product.model.*"%>
<%-- �����Ƚm�߱ĥ� Script ���g�k���� --%>

<%
  ProductVO productVO = (ProductVO) request.getAttribute("productVO"); //EmpServlet.java(Concroller), �s�Jreq��empVO����
%>

<html>
<head>
<title>�ӫ~��� - listOneProduct.jsp</title>

<style>
  table#table-1 {
	background-color: #CCCCFF;
    border: 2px solid black;
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

<style>
  table {
	width: 600px;
	background-color: white;
	margin-top: 5px;
	margin-bottom: 5px;
  }
  table, th, td {
    border: 1px solid #CCCCFF;
  }
  th, td {
    padding: 5px;
    text-align: center;
  }
</style>

</head>
<body bgcolor='white'>

<h4>�����Ƚm�߱ĥ� Script ���g�k����:</h4>
<table id="table-1">
	<tr><td>
		 <h3>�ӫ~��� - listOneProduct.jsp</h3>
		 <h4><a href="select_page.jsp">�^����</a></h4>
		 <h4><a href="listAllProduct_byDAO.jsp">�^�ؿ�</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<th>�ӫ~�s��</th>
		<th>�~�Ƚs��</th>
		<th>�����s��</th>
		<th>�ӫ~�W��</th>
		<th>�ӫ~�y�z</th>
		<th>����</th>
		<th>�ƶq</th>
		<th>�f�֪��A</th>
		<th>�W�U�[���A</th>
	</tr>
	<tr>
		<td><%=productVO.getProductId()%></td>
		<td><%=productVO.getSellerId()%></td>
		<td><%=productVO.getCategoryId()%></td>
		<td><%=productVO.getName()%></td>
		<td><%=productVO.getDescription()%></td>
		<td><%=productVO.getPrice()%></td>
		<td><%=productVO.getQuantity()%></td>
		<td><%=productVO.getReviewStatus()%></td>
		<td><%=productVO.getProductStatus()%></td>
	</tr>
</table>

</body>
</html>