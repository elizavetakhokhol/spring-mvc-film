 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<jsp:include page="_header.jsp"/>

<c:if test="${user.admin}">
    <a href="/film/create">Create</a>
</c:if>
<table class="table">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Title</th>
        <th scope="col">Genre</th>
        <th scope="col">Year</th>
        <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="film" items="${films}" >
        <tr>
            <td><c:out value="${film.id}" /></td>
            <td><c:out value="${film.title}" /></td>
            <td><c:out value="${film.genre}" /></td>
            <td><c:out value="${film.year}" /></td>
            <td>
                <c:if test="${not empty user}">
                <a href="/film/estimate/${film.title}">Estimate</a>
                </c:if>
                <c:if test="${user.admin}">
                    <a href="/film/edit/${film.title}">Edit</a>
                </c:if>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

${sessionScope.messageReg}
</body>
</html>
