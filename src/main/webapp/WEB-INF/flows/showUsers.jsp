<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head><title>Spring Web Flow - Show users</title></head>

<body>
        <c:forEach items="${users.users}" var="user">
            <text>Name:</text>
            <c:out value="${user.givenName}" />
            <c:out value="${user.familyName}" />
            <text>other information:</text>
            <c:out value="${user.details}" />
            </br>
		</c:forEach>

</body>

</html>