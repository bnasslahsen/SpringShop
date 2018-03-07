<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Item list page</title>
</head>
<body>
	<h1>Items:</h1>
	<c:forEach items="${items}" var="item">
		${item.description} (${item.price}) <br />
	</c:forEach>
</body>
</html>