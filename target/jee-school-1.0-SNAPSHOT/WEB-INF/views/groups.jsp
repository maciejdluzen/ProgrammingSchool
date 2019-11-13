<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: maciej
  Date: 10/11/2019
  Time: 20:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of groups in the programming school</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<section>
    <h2>Current list of groups</h2>
    <table border="1">
        <tr>
            <th>Group ID</th>
            <th>Group Name</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${allGroups}" var="group">
        <tr>
            <td>${group.id}</td>
            <td>${group.name}</td>
            <td><a href='<c:url value="/usersFromAGroup?id=${group.id}"/>'>Details</a></td>
        </tr>
        </c:forEach>
    </table>
</section>
</body>
</html>
