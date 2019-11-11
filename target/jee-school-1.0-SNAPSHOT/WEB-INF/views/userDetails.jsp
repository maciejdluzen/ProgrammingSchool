<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: maciej
  Date: 11/11/2019
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Details</title>
</head>
<body>
    <section>
        <h2>User details: ${userDetails.username}</h2>
        Name: ${userDetails.username} <br>
        <br>
        Email address: ${userDetails.email} <br>
        <br>
        Password: ${userDetails.password} <br>
        <br>
        <b>Solutions added by this user:</b>
    </section>
    <section>
        <table>
            <tr>
                <td>Solution ID</td>
                <td>Exercise ID</td>
                <td>Created</td>
                <td>Action</td>
            </tr>
        <c:forEach items="${userSolutions}" var="solution">
            <tr>
                <td>${solution.id}</td>
                <td>${solution.exerciseId}</td>
                <td>${solution.created}</td>
                <td><a href='<c:url value="/solutionDetails?id=${solution.id}"/>'>Details</a></td>
            </tr>
        </c:forEach>
        </table>
    </section>
</body>
</html>
