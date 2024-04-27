<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.product.model.*"%>

<%
// EmpVO empVO = (EmpVO) request.getAttribute("empVO");
%>

<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>���u��ƭק� - update_product_input.jsp</title>

<style>
table#table-1 {
	width: 450px;
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
	background-color: white;
	margin-top: 1px;
	margin-bottom: 1px;
}

table, th, td {
	border: 0px solid #CCCCFF;
}

th, td {
	padding: 1px;
}
</style>

</head>
<body bgcolor='white'>

	<table id="table-1">
		<tr>
			<td>
				<h3>�ӫ~��ƭק� - update_product_input.jsp</h3>
				<h4>�^����</h4>
			</td>
		</tr>
	</table>

	<h3>��ƭק�:</h3>

	<%-- ���~��C --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color: red">�Эץ��H�U���~:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color: red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>

	<FORM METHOD="post" ACTION="product.do" name="form1">
		<table>
			<tr>
				<td>�ӫ~�s��:<font color=red><b>*</b></font></td>
				<td>${param.productId}</td>
			</tr>
			<tr>
				<td>�ӫ~�W��:</td>
				<td><input type="TEXT" name="name" value="${param.name}"
					size="45" /></td>
				<td>${errorMsgs.name}</td>
			</tr>
			<tr>
				<td>����:</td>
				<td><input type="TEXT" name="price" value="${param.price}"
					size="45" /></td>
				<td>${errorMsgs.price}</td>
			</tr>
			<tr>
				<td>�ƶq:</td>
				<td><input type="TEXT" name="quantity"
					value="${param.quantity}" size="45" /></td>
				<td>${errorMsgs.quantity}</td>
			</tr>
			<tr>
				<td>�ӫ~�y�z:</td>
				<td><input type="TEXT" name="description"
					value="${param.description}" size="45" /></td>
				<td>${errorMsgs.description}</td>
			</tr>
			<jsp:useBean id="productSev" scope="page"
				class="com.product.model.ProductService" />
			<tr>
				<td>����:<font color=red><b>*</b></font></td>
				<td><select size="1" name="categoryId">
						<c:forEach var="productVO" items="${productSev.all}">
							<option value="${productVO.categoryId}"
								${(productVO.categoryId==productVO.categoryId)? 'selected':'' }>${productVO.categoryId}
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>��a�s��:<font color=red><b>*</b></font></td>
				<td><select size="1" name="sellerId">
						<c:forEach var="productVO" items="${productSev.all}">
							<option value="${productVO.sellerId}"
								${(productVO.sellerId==productVO.sellerId)? 'selected':'' }>${productVO.sellerId}
						</c:forEach>
				</select></td>
			</tr>

			<tr>
				<td>�f�֪��A:<font color=red><b>*</b></font></td>
				<td><select size="1" name="reviewStatus">
						<c:forEach var="productVO" items="${productSev.all}">
							<option value="${productVO.reviewStatus}"
								${(productVO.reviewStatus==productVO.reviewStatus)? 'selected':'' }>${productVO.reviewStatus}
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>�W�[�s��:<font color=red><b>*</b></font></td>
				<td>
<!-- 					<select size="1" name="productStatus"> -->
<%-- 						<c:forEach var="productVO" items="${productSev.all}"> --%>
<%-- 							<option value="${productVO.productStatus}" --%>
<%-- 								${(productVO.productStatus==productVO.productStatus)? 'selected':'' }>${productVO.productStatus} --%>
<%-- 						</c:forEach> --%>
<!-- 					</select> -->
					<input type="radio" id="option0" name="productStatus" value="0" <c:if test="${param.productStatus eq '0'}">checked</c:if>>
					<label for="option0">�U�[</label>
					
					<input type="radio" id="option1" name="productStatus" value="1" <c:if test="${param.productStatus eq '1'}">checked</c:if>>
					<label for="option1">�W�[</label>
				</td>
			</tr>

		</table>
		<br> <input type="hidden" name="action" value="update"> <input
			type="hidden" name="productId" value="${param.productId}"> <input
			type="submit" value="�e�X�ק�">
	</FORM>
</body>



<!-- =========================================�H�U�� datetimepicker �������]�w========================================== -->

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/datetimepicker/jquery.datetimepicker.css" />
<script src="<%=request.getContextPath()%>/datetimepicker/jquery.js"></script>
<script
	src="<%=request.getContextPath()%>/datetimepicker/jquery.datetimepicker.full.js"></script>

<style>
.xdsoft_datetimepicker .xdsoft_datepicker {
	width: 300px; /* width:  300px; */
}

.xdsoft_datetimepicker .xdsoft_timepicker .xdsoft_time_box {
	height: 151px; /* height:  151px; */
}
</style>

</html>