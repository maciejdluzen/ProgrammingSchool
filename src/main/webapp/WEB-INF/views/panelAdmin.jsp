<%--
  Created by IntelliJ IDEA.
  User: maciej
  Date: 11/11/2019
  Time: 18:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="webapp/css/style.css"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Admin Panel</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<h2 id="header2">Admin Panel</h2>
<h3>Select action:</h3>
    <ul>
        <li><a href="http://localhost:8080/manageExercises">Manage exercises</a></li><br>
        <li><a href="http://localhost:8080/manageGroups">Manage groups</a></li><br>
        <li><a href="http://localhost:8080/manageUsers">Manage users</a></li>
    </ul>
</body>
</html>
