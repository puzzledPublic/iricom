<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form:form  enctype="multipart/form-data">
	productName<input type="text" id="productName" name="productName" value="productName"><br>
	brandName<input type="text" id="brandName" name="brandName" value="brandName"><br>
	category<input type="text" id="category" name="category" value="0"><br>
	price<input type="text" id="price" name="price" value="2000"><br>
	material<input type="text" id="material" name="material" value="cotton"><br>
	size1<input type="text" id="size" name="size" value="95"><br>
	stock1<input type="text" id="stock" name="stock" value="95"><br>
	size2<input type="text" id="size" name="size" value="100"><br>
	stock2<input type="text" id="stock" name="stock" value="100"><br>
	size3<input type="text" id="size" name="size" value="105"><br>
	stock3<input type="text" id="stock" name="stock" value="105"><br>
	
	<input type="file" id="image" name="image" ><br>
	<input type="submit" value="전송">
</form:form>
</body>
</html>