<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form id="loginfirm" action="./login" method="post">
	<table>
		<tr>
			<td>id</td>
			<td><input type="text" id="loginid" name="loginid" value=""></td>
		</tr>
		<tr>
			<td>pw</td>
			<td><input type="text" id="loginpw" name="loginpw" value=""></td>
		</tr>
		<tr>
			<td><input type="submit" id="loginbtn" value="login"></td>
		</tr>
	</table>
	<input type="hidden" name="lognRedirect" value="">
</form:form>
</body>
</html>