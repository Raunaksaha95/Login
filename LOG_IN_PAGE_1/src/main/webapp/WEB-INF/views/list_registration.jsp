<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.sql.ResultSet"%>
<%@ include file="menu.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	background-color: #57d7fe;
}
</style>
</head>
<body>
	<h2>Registration !! All Details</h2>

	<table>
		<tr>
			<th>Name</th>
			<th>City</th>
			<th>Email</th>
			<th>Mobile</th>
			<th>Delete</th>
	        <th>Update</th>
			
		</tr>


		<%
		ResultSet res = (ResultSet) request.getAttribute("res");
		while (res.next()) {
		%>

		<tr>
			<td><%=res.getString(1)%></td>
			<td><%=res.getString(2)%></td>
			<td><%=res.getString(3)%></td>
			<td><%=res.getString(4)%></td>
<td><a href="delete?email=<%=res.getString(3)%>"onclick="return checkDelete()">Delete</a></td>
<td><a href="update?email=<%=res.getString(3)%>&mobile=<%=res.getString(4)%>">Update</a></td>

		</tr>

		<%
		}
		%>
	</table>
	
	<script type="text/javascript">
	function checkDelete(){
		return confirm('Do you want to delete');
	}
	
	</script>






</body>
</html>