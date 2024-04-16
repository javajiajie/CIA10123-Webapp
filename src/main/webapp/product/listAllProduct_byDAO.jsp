<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.product.model.*"%>
<%-- �����m�߱ĥ� EL ���g�k���� --%>

<%
ProductService PSer = new ProductService();
List<ProductVO> list = PSer.getAll(); // ���檺list�ܼ�(����)�N����page1.file����11����o�d�ߨ쪺�`���ơA�A��page1.file�i��������ݭn
pageContext.setAttribute("list", list); // �̤p�A�N�W�@�檺list�ܼ�(����)�s�J��e����pageContext�A�A�ѩ��U����73���JSTL��forEach�C�L�X���G
%>


<html>
<head>
<title>�Ҧ��ӫ~��� - listAllProduct_byDAO.jsp</title>

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
	width: 800px;
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

	<h4>�����m�߱ĥ� EL ���g�k����:</h4>
	<table id="table-1">
		<tr>
			<td>
				<h3>�Ҧ��ӫ~��� - listAllProduct_byDAO.jsp</h3>
				<h4>
					<a href="select_page.jsp">�^����</a>
				</h4>
			</td>
		</tr>
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
		</tr>
		<%@ include file="page1.file"%>
		<c:forEach var="productVO" items="${list}" begin="<%=pageIndex%>"
			end="<%=pageIndex+rowsPerPage-1%>">
			<tr>
				<td>${productVO.productId}</td>
				<td>${productVO.sellerId}</td>
				<td>${productVO.categoryId}</td>
				<td>${productVO.name}</td>
				<td>${productVO.description}</td>
				<td>${productVO.price}</td>
				<td>${productVO.quantity}</td>
				<td>
				<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/product/product.do" style="margin-bottom: 0px;">
					<input type="submit" value="�ק�"> 
					<input type="hidden" name="productId" value="${productVO.productId}"> 
					<input type="hidden" name="action" value="getOne_For_Update">
				</FORM>
				</td>
			</tr>
		</c:forEach>
	</table>
	<%@ include file="page2.file"%>

</body>
</html>