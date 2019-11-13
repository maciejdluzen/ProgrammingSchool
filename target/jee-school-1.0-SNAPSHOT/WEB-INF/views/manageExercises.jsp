<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: maciej
  Date: 13/11/2019
  Time: 09:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Exercises management panel</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<section>
    <h2>Exercises management panel</h2>
    <a href='<c:url value="/createExercise"/>'>New exercise</a>
    <table border="1">
        <tr>
            <th>Exercise ID</th>
            <th>Title</th>
            <th>Description</th>
            <th>Actions</th>
        </tr>
        <c:forEach items="${allExercises}" var="exercise">
            <tr>
                <th>${exercise.id}</th>
                <th>${exercise.title}</th>
                <th>${exercise.description}</th>
                <td><a href='<c:url value="/deleteExercise?id=${exercise.id}"/>'>Delete</a></td>
                <td><a href='<c:url value="/editExercise?id=${exercise.id}"/>'>Edit</a></td>
            </tr>
        </c:forEach>
    </table>
</section>
</body>
</html>
