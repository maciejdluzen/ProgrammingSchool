<%--
  Created by IntelliJ IDEA.
  User: maciej
  Date: 11/11/2019
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Solution Details: </title>
</head>
<body>
<jsp:include page="header.jsp"/>
<section>
    <h2>Solution Details: solution ID: ${solutionDetails.id} exercise ID: ${solutionDetails.exerciseId}</h2>
    ${solutionDetails.description}
</section>
</body>
</html>
