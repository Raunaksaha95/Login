<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body{
background-color: aqua;
}
</style>
</head>
<body>

	<div>
		<h1>Login Here</h1>
		<form action="verifyLogin" method="post">
			Email <input type="text" name="email"> Password <input
				type="password" name="password"> <input type="submit"
				value="Login" />
		</form>
	</div>
	
	<div>
	<%
	if(request.getAttribute("errormsg")!=null){
		out.println(request.getAttribute("errormsg"));	
	}
	%>
	</div>

</body>
</html>