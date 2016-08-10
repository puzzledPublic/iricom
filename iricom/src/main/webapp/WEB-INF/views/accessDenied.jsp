<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>접근제한</title>
</head>
<body>
${errorMsg }<br>
접근 권한이 없습니다.
<a href="<%= request.getContextPath() %>/main">메인으로</a>
</body>
</html>