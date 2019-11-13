<%--
  Created by IntelliJ IDEA.
  User: maciej
  Date: 12/11/2019
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Group </title> <%-- ${group.id} --%>
</head>
<body>
<jsp:include page="header.jsp"/>
<h2>Edit Group: ${group.name}</h2> <%-- nie dziala dodawanie numeru --%>
<form action="/editGroup" method="post">
    Group id: <input type="text" name="groupId" value="${group.id}" readonly>
    New group name: <input type="text" name="newGroupName"/>
    <br/>
    <button type="submit">Submit</button>
</form>
</body>
</html>
