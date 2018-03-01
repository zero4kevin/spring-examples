<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<<<<<<< HEAD
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
=======
>>>>>>> 16ced1d953fd8c047b239dfac4bb972d3aa8c3cb
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