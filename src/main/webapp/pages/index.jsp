<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Film Ranking</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<h1>Hye , ${user.name.equals("") ? "Guest" : user.name}</h1>
<p>This project let you to estimate films</p>
</body>
</html>