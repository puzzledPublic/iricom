<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<button onclick="test()">Click me</button>
<p id="demo"></p>

<script>
var test= function () {
    document.getElementById("demo").innerHTML = "test";
}
</script>
</body>
</html>
