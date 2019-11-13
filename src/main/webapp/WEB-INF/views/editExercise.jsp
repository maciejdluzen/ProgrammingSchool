<%--E
  Created by IntelliJ IDEA.
  User: maciej
  Date: 13/11/2019
  Time: 10:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Exercise edit panel</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<h2>Exercise edit: ${exercise.title}</h2>
<form action="/editExercise" method="post">
    Exercise ID: <input type="text" name="id" value="${exercise.id}" readonly>
    Title: <input type="text" name="title"/>
    <br/>
    Description: <input type="text" name="description"/>
    <br/>
    <button type="submit">Submit</button>
</form>
</body>
</html>
