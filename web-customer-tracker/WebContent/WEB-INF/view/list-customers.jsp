<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
	<title>Customer List</title>
	<link type="text/css" rel = "stylesheet" href = "${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
<body>
	<div id = "wrapper">
		<div id = "header">
			<h2>CRM APPLICATION</h2>
		</div>
	</div>
	
	<div id = "container">
		<div id = "content">
		
			<input type="button" value = "Add New Customer" onclick="window.location.href='showFormForAdd'; return false;"
			class = "add-button"/>
		
			<table border = "1">
				<tr>
					<th>FIRST NAME</th>
					<th>LAST NAME</th>
					<th>EMAIL</th>
					<th>ACTION</th>
				</tr>
				
				<c:forEach var = "tempCus" items = "${customers}">
					<c:url var = "updateLink" value = "/customer/showFormUpdate">
					<c:param name="customerId" value = "${tempCus.id}"></c:param>
					</c:url>
					<c:url var = "deleteLink" value = "/customer/delete">
					<c:param name="customerId" value = "${tempCus.id}"></c:param>
					</c:url>
					<tr>
						<td>${tempCus.firstName}</td>
						<td>${tempCus.lastName}</td>
						<td>${tempCus.email}</td>
						<td>
						<a href = "${updateLink}">Update</a>
						|
						<a href = "${deleteLink}" onclick="if(!(confirm('Are you sure you want to delete this'))) return false">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		
		</div>
	</div>
</body>
</html>