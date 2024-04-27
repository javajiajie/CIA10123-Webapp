<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/main/main.css">
<title>Product Image</title>
</head>
<body>
	<h1>一般商品圖庫</h1>
	<h2>圖庫查詢系統</h2>
	<a href="${pageContext.request.contextPath}/product/productImg.do?action=getAll">查詢圖庫</a>
	<br><br>
	<h3><b>複合查詢 (使用 Criteria Query)：</b></h3>
	<form action="${pageContext.request.contextPath}/product/productImg.do" method="post">
<!-- 		<p><label>圖片編號模糊查詢：</label></p> -->
<!-- 		<input type="text" name="imageId"><br> -->
		<p><label>商品編號模糊查詢：</label></p>
		<input type="text" name="productId"><br>
<!-- 		</form> -->
<%-- 		<form action="${pageContext.request.contextPath}/product/product.do" method="post"> --%>
<!-- 		<form ACTION="product/product.do" method="post"> -->
		<p><label>商品名字模糊查詢：</label></p>
<!-- 		<input type="text" name="productVO.name"><br> -->
		
		<p><label>以圖搜圖：</label></p>
<!-- 		<input type="text" name="image"><br> -->
<!-- 		<form action="ImageSearchServlet" method="post" enctype="multipart/form-data"> -->
        <input type="file" name="image" accept="image/*">
        <input type="submit" value="搜尋">
		
		<p><input type="submit" value="送出"></p>
		<input type="hidden" name="action" value="compositeQuery">
		
	</form>
</body>
</html>