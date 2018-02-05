<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head><title>Spring Web Flow - Create a new user</title></head>
<body>
    <h2>Create a new user</h2>
    <form:form modelAttribute="user">
        <input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}">
        <b>Family Name:  </b> <form:input path="familyName" /><br/>
        <b>Given Name:   </b> <form:input path="givenName" /><br/>
        <b>Other Inform: </b> <form:input path="details" /><br/>
        <input type="submit" class="button" name="_eventId_submit" value="Submit">
        <input type="submit" class="button" name="_eventId_cancel" value="Cancel">
    </form:form>
</body>
</html>
