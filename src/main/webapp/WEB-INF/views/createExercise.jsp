<%--
  Created by IntelliJ IDEA.
  User: maciej
  Date: 13/11/2019
  Time: 09:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New exercise addition panel</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<h2>New exercise addition panel</h2>
<form action="/createExercise" method="post">
    Title: <input type="text" name="title"/>
    <br/>
    Description: <input type="text" name="description"/>
    <br/>
    <button type="submit">Submit</button>
</form>
</body>
</html>
