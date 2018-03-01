<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
This is a web application trial
</head>

<body>
<security:authorize access="isAnonymous()">
<h2>welcome <c:out value="${pageContext.request.remoteUser}"/></h2> <br/>
<a href="/security-example/member">Please login</a>
<a href="/security-example/registration">Register a new user</a>
</security:authorize>
<security:authorize access="hasRole('MEMBERS')">
<h2>Hello <security:authentication property="principal.username" /></h2>
<br/>

<form:form action="logout" method="POST">
<!--${pageContext.request.contextPath}/logout -->
    <input type="submit" value="logout" />
</form:form>

</security:authorize>
</body>

</html>