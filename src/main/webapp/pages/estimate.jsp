<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Estimate</title>
</head>

<body>

<jsp:include page="_header.jsp"/>


<c:if test="${not empty userfilm}">
    <h1>
        Your estimation: ${userfilm.point} <br>
        Change it
    </h1>
</c:if>

<form action="/film/estimate" method="post">
    <input type="hidden" name="userId" class="form-control" id="uid" aria-describedby="nameHelp" value="${user.id}">
    <input type="hidden" name="filmId" class="form-control" id="fid" aria-describedby="nameHelp" value="${film.id}">
    <div class="mb-3">
        <div class="form-check">
            <input class="form-check-input" type="radio" value="1" ${userfilm.point == 1 ? "checked" : ""} id="defaultCheck1" name="point">
            <label class="form-check-label" for="defaultCheck1">
                Rank 1
            </label>
        </div>
        <div class="form-check">
            <input class="form-check-input" type="radio" value="2" ${userfilm.point == 2 ? "checked" : ""} id="defaultCheck2" name="point">
            <label class="form-check-label" for="defaultCheck2">
                Rank 2
            </label>
        </div>
        <div class="form-check">
            <input class="form-check-input" type="radio" value="3" ${userfilm.point == 3 ? "checked" : ""} id="defaultCheck3" name="point">
            <label class="form-check-label" for="defaultCheck3">
                Rank 3
            </label>
        </div>
        <div class="form-check">
            <input class="form-check-input" type="radio" value="4" ${userfilm.point == 4 ? "checked" : ""} id="defaultCheck4" name="point">
            <label class="form-check-label" for="defaultCheck4">
                Rank 4
            </label>
        </div>
        <div class="form-check">
            <input class="form-check-input" type="radio" value="5" ${userfilm.point == 5 ? "checked" : ""} id="defaultCheck5" name="point">
            <label class="form-check-label" for="defaultCheck5">
                Rank 5
            </label>
        </div>
    </div>
    <c:if test="${not empty userfilm}">
        <button type="submit" class="btn btn-primary">Change film estimation</button>
    </c:if>
    <c:if test="${empty userfilm}">
        <button type="submit" class="btn btn-primary">Estimate film</button>
    </c:if>
</form>


</body>
</html>
