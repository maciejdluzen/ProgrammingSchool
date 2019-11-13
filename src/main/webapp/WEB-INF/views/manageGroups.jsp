<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: maciej
  Date: 11/11/2019
  Time: 18:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Groups management panel</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<section>
    <h2>Groups management panel</h2>
    <a href='<c:url value="/createGroup"/>'>New group</a>  <%-- dodac sciezke servletu --%>
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
                <td><a href='<c:url value="/deleteGroup?id=${group.id}"/>'>Delete</a></td> <%-- Usuwanie grupy nie dziala --%>
                <td><a href='<c:url value="/editGroup?id=${group.id}"/>'>Edit</a></td>
            </tr>
        </c:forEach>
    </table>
</section>
</body>
</html>
