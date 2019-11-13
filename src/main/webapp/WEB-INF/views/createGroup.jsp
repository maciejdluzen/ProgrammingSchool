<%--
  Created by IntelliJ IDEA.
  User: maciej
  Date: 12/11/2019
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new group</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<form action="/createGroup" method="post">
    Group name: <input type="text" name="groupName"/>
    <br/>
    <button type="submit">Submit</button>
</form>
</body>
</html>
