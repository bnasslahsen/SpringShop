<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Add order page</title>
</head>
<body>
	<h1>Add an order</h1>
	<sf:form method="POST" modelAttribute="orderModel">
		<table>
			<tr>
				<td>Customer ID:</td>
				<td><sf:input path="customerID" /> <sf:errors
						path="customerID" /></td>
			</tr>
			<tr>
				<td>Order ID:</td>
				<td><sf:input path="orderID" /> <sf:errors path="orderID" /></td>
			</tr>
			<tr>
				<td>Items:</td>
				<td><c:forEach items="${orderModel.items}" var="item">
						<sf:checkbox path="itemIDs" value="${item.itemID}" /> ${item.description} (${item.price}) <br />
					</c:forEach> <sf:errors path="itemIDs" /></td>
			</tr>
		</table>
		<input type="submit" value="submit" />
	</sf:form>
</body>
</html>
