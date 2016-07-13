<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>또바기</title>
</head>
<body>
<form:form action="./write" method="post">
	제목<input type="text" id="title" name="title">
	내용<input type="text" id="content" name="content">
	   <input type="hidden" id="bn" name="bn" value="${param.bn }">
	   <input type="submit" value="전송"> 
</form:form>
</body>
</html>