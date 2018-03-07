<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
	<title>Index page</title>
</head>
<body>

	<h1>Welcome</h1>

	<security:authorize access="isAnonymous()">
		<p>
			You are not logged in. (<a href="<c:url value='/login' />">Log in</a>)
		</p>
	</security:authorize>

	<security:authorize access="isAuthenticated()">
		<p>
			You are logged in with user '
			<security:authentication property="principal.username" />
			'. (<a href="<c:url value='/login' />">Log out</a>)
		</p>
	</security:authorize>

	You can visit the following pages:

	<ul>
		<li><a href="items">See the item list</a></li>
		<security:authorize
			access="hasRole('ROLE_NORMAL_USER') or hasRole('ROLE_ADMIN')">
			<li><a href="addOrder">Add an order</a></li>
		</security:authorize>
		<security:authorize access="hasRole('ROLE_ADMIN')">
			<li><a href="createItemFlow">Create an item</a></li>
		</security:authorize>
	</ul>
</body>
</html>
