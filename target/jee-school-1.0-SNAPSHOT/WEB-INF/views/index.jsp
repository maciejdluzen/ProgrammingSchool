<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: maciej
  Date: 08/11/2019
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Programming School</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<section>
    <h2>Latest solutions</h2>
    <table>
        <tr>
            <th>Lp.</th>
            <th>Exercise ID</th>
            <th>User ID</th>
            <th>Creation date</th>
            <th>Actions</th>
        </tr>
        <c:forEach items="${solutions}" var="solution" varStatus="stat">
        <tr>
            <td>${stat.count}</td>
            <td>${solution.exerciseId}</td>
            <td>${solution.userId}</td>
            <td>${solution.created}</td>
            <td><a href='<c:url value="/solutionDetails?id=${solution.id}"/>'>Details</a></td>
        </tr>
        </c:forEach>
    </table>
</section>
<jsp:include page="footer.jsp"/>
</body>
</html>
