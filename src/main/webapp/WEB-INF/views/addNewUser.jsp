<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: maciej
  Date: 12/11/2019
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New user addition panel</title>
</head>
<body>
<h2>New user addition panel</h2>
<form action="/addNewUser" method="post">
    Username: <input type="text" name="username"/>
    <br/>
    Email: <input type="text" name="email"/>
    <br/>
    Password: <input type="text" name="password"/>
    <br/>
    Group ID and name:
    <select name="groupId">
    <c:forEach items="${allGroups}" var="group">
        <option value="${group.id}" ${group == allGroups ? 'selected' : ' '}>${group.id} ${group.name}</option>
    </c:forEach>
    </select>
    <button type="submit">Submit</button>
</form>
</body>
</html>
