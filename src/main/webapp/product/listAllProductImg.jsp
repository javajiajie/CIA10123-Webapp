<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/main/main.css">
<title>List ProductImgs</title>
</head>
<body>
	<h1>圖片列表</h1>
	<c:if test="${productImgPageQty > 0}">
  		<b><font color=red>第${currentPage}/${productImgPageQty}頁</font></b>
	</c:if>
	<br>
<%-- 	<img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/img/cat.png"> --%>
<%-- 	<img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/img/cat.png"> --%>
<%-- 	<img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/img/cat.png"> --%>
	<table style="width:50%; text-align:center;">
		<tr>
			<th>圖片編號</th>
			<th>商品編號</th>
			<th>商品圖片</th>
		</tr>
		<c:forEach var="productImg" items="${productImgList}">
			<tr>
				<td>${productImg.imageId}</td>
				<td>${productImg.productId}</td>
				<td>${productImg.image}</td>
			</tr>
		</c:forEach>
	</table>
	<c:if test="${currentPage > 1}">
		<a href="${pageContext.request.contextPath}/product/productImg.do?action=getAll&page=1">至第一頁</a>&nbsp;
	</c:if>
	<c:if test="${currentPage - 1 != 0}">
		<a href="${pageContext.request.contextPath}/product/productImg.do?action=getAll&page=${currentPage - 1}">上一頁</a>&nbsp;
	</c:if>
	<c:if test="${currentPage + 1 <= empPageQty}">
		<a href="${pageContext.request.contextPath}/product/productImg.do?action=getAll&page=${currentPage + 1}">下一頁</a>&nbsp;
	</c:if>
	<c:if test="${currentPage != empPageQty}">
		<a href="${pageContext.request.contextPath}/product/productImg.do?action=getAll&page=${empPageQty}">至最後一頁</a>&nbsp;
	</c:if>
	<br>
<%-- 	<img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/img/inversecat.png"> --%>
<%-- 	<img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/img/inversecat.png"> --%>
<%-- 	<img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/img/inversecat.png"> --%>
	<br><br>
	
	<a href="${pageContext.request.contextPath}/index.jsp">回首頁</a>	
</body>
</html>