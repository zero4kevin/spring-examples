<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>Create a new user</head>

<body>
<form:form id="registerUser" action="registration" method="post" modelAttribute="user">
<table>
	<tr>
		<td><form:label path="accountName">User Name</form:label></td>
		<td><form:input path="accountName" name="accountName" id="username" /></td>
	</tr>
	<tr>
		<td><form:label path="firstName">Given Name</form:label></td>
		<td><form:input path="firstName" name="givenname" id="givenname"/></td>
    </tr>
	<tr>
		<td><form:label path="lastName">Surname</form:label></td>
		<td><form:input path="lastName" name="surname" id="surname"/></td>
	</tr>
	<tr>
		<td><form:label path="password">Password</form:label></td>
		<td><form:input path="password" name="password" id="password"/></td>
	</tr>
	<tr>
		<td><form:label path="confirmPassword">Confirm Password</form:label></td>
		<td><form:input path="confirmPassword" name="confirmpassword" id="confirmpassword"/></td>
	</tr>
	<tr>
		<td><form:label path="email">Email</form:label></td>
		<td><form:input path="email" name="email" id="email" /></td>
	</tr>
	<tr>
		<td></td>
		<td><form:button id="register" name="register">Register</form:button></td>
	</tr>
	<tr>
      <td></td>
      <td><a href="/">Home</a></td>
   </tr>
</table>
</form:form>
</body>

</html>