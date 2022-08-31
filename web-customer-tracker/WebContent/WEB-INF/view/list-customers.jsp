<%@ taglib 	uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>

<html>

<head>
	<title> List Customers </title>
	<!-- reference style sheet -->
	<link type = "text/css"
	rel = "stylesheet"
	href = "${pageContext.request.contextPath}/resources/css/style.css" />
	
</head>

<body>
	<div id = "wrapper">
		<div id = "header">
			<h2>
				Customer Relationship Manager
			</h2>
		</div>
	</div>
	
	<div id = "container">
		<div id = "content">
			<!-- add out htmml table here -->
			<table>
				<tr>
					<th> First name &nbsp </th>
					<th> Last name &nbsp </th>
					<th> Email </th>
				</tr>	
			<!-- loop over and print customers -->
				<c:forEach var="tempCustomer" items="${customers}">
					<tr>
						<td> ${tempCustomer.firstName} </td>
						<td> ${tempCustomer.lastName} </td>
						<td> ${tempCustomer.email} </td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>

</body>

</html>