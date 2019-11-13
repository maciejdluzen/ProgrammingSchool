<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: maciej
  Date: 12/11/2019
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users management panel</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<section>
    <h2>Users management panel</h2>
    <a href='<c:url value="/createUser"/>'>New user</a>
    <table border="1">
         <tr>
            <th>User ID</th>
            <th>Username</th>
            <th>Actions</th>
             <th>Actions</th>
         </tr>
        <c:forEach items="${allUsers}" var="user">
         <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td><a href='<c:url value="/deleteUser?id=${user.id}"/>'>Delete</a></td>
            <td><a href='<c:url value="/editUser?id=${user.id}"/>'>Edit</a></td>
         </tr>
        </c:forEach>
</table>
</section>
</body>
</html>
