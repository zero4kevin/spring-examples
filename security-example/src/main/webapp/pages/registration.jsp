<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>Create a new user</head>

<body>
<form:form id="registerUser" action="registration" method="post" modelAttribute="user">
<table>
	<tr>
		<td><form:label path="accountName">User Name</form:label></td>
		<td><form:input path="accountName" id="username" /></td>
	</tr>
	<tr>
		<td><form:label path="firstName">Given Name</form:label></td>
		<td><form:input path="firstName"  id="givenname"/></td>
    </tr>
	<tr>
		<td><form:label path="lastName">Surname</form:label></td>
		<td><form:input path="lastName"  id="surname"/></td>
	</tr>
	<tr>
		<td><form:label path="password">Password</form:label></td>
		<td><form:password path="password"  id="password"/></td>
	</tr>
	<tr>
		<td><form:label path="confirmPassword">Confirm Password</form:label></td>
		<td><form:password path="confirmPassword" id="confirmpassword"/></td>
	</tr>
	<tr>
		<td><form:label path="email">Email</form:label></td>
		<td><form:input path="email"  id="email" /></td>
	</tr>
	<tr>
		<td></td>
		<td><form:button id="register" name="register">Register</form:button></td>
	</tr>
	<tr>
      <td></td>
      <td><a href="/security-example">Home</a></td>
   </tr>
</table>
</form:form>
</body>

</html>