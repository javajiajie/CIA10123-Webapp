<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="BIG5"%>
<%@ page import="com.product.model.*"%>
<%-- 此頁暫練習採用 Script 的寫法取值 --%>

<%
  ProductVO productVO = (ProductVO) request.getAttribute("productVO"); //EmpServlet.java(Concroller), 存入req的empVO物件
%>

<html>
<head>
<title>商品資料 - listOneProduct.jsp</title>

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

<h4>此頁暫練習採用 Script 的寫法取值:</h4>
<table id="table-1">
	<tr><td>
		 <h3>商品資料 - listOneProduct.jsp</h3>
		 <h4><a href="select_page.jsp">回首頁</a></h4>
		 <h4><a href="listAllProduct_byDAO.jsp">回目錄</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<th>商品編號</th>
		<th>業務編號</th>
		<th>分類編號</th>
		<th>商品名稱</th>
		<th>商品描述</th>
		<th>價格</th>
		<th>數量</th>
		<th>審核狀態</th>
		<th>上下架狀態</th>
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