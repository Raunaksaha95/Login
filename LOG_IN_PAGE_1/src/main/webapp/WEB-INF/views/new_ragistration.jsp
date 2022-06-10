<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Registration</title>
<style>
body {
	background-color: aqua;
}
</style>
</head>
<body>

	<h2>New || Registration</h2>
	<form action="new" method="post">
		<pre>
		Name<input type="text" name="name">
	    City<input type="text" name="city"> 
		Email<input type="text" name="email">
		Mobile<input type="text" name="mobile">
		<input type="submit"value="save">
		</pre>
	</form>
	
		<div>
	<%
	if(request.getAttribute("msg")!=null){
		out.println(request.getAttribute("msg"));	
	}
	%>
	</div>
</body>
</html>