<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: maciej
  Date: 11/11/2019
  Time: 11:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of users in the programming school</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<section>
    <h2>Current list of users in the group: ${groupName.name}</h2>
    <table border="1">
        <tr>
            <th>User ID</th>
            <th>Username</th>
            <th>Actions</th>
        </tr>
        <c:forEach items="${allUsers}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td><a href='<c:url value="/userDetails?id=${user.id}"/>'>Details</a></td>
            </tr>
        </c:forEach>
    </table>
</section>
</body>
</html>
