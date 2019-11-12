<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: maciej
  Date: 12/11/2019
  Time: 18:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User edit panel</title>
</head>
<body>
<h2>Edit User: ${user.username}</h2>
<form action="/editUser" method="post">
    User id: <input type="text" name="userId" value="${user.id}" readonly>
    <br/>
    New username: <input type="text" name="username" value="${user.username}">
    <br/>
    New email: <input type="text" name="email" value="${user.email}">
    <br/>
    Password: <input type="text" name="password" value="${user.password}" readonly>
    <br/>
    New group (current group ID is: ${user.userGroupId})
    <select name="groupId">
        <c:forEach items="${allGroups}" var="group">
            <option value="${group.id}" ${group == allGroups ? 'selected' : ' '}>${group.id} ${group.name}</option>
        </c:forEach>
    </select>
    <button type="submit">Edit</button>
</form>
</body>
</html>
