<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<jsp:include page="_header.jsp"/>

<form action="/user/reg" method="post">
    <div class="mb-3">
        <label for="name" class="form-label">Name</label>
        <input type="text" name="name" class="form-control" id="name" aria-describedby="nameHelp">
        <p style="color: red">${name}</p>
    </div>
    <div class="mb-3">
        <label for="login" class="form-label">Login</label>
        <input type="text" name="login" class="form-control" id="login" aria-describedby="loginHelp">
    </div>
    <div class="mb-3">
        <label for="password" class="form-label">Password</label>
        <input type="password" name="password" class="form-control" id="password">
    </div>
    <div class="mb-3">
        <div class="form-check">
            <input class="form-check-input" type="radio" value="true" id="defaultCheck1" name="admin">
            <label class="form-check-label" for="defaultCheck1">
                Manager
            </label>
        </div>
        <div class="form-check">
            <input class="form-check-input" type="radio" value="false" checked id="defaultCheck2" name="admin">
            <label class="form-check-label" for="defaultCheck2">
                User
            </label>
        </div>
    </div>
    <button type="submit" class="btn btn-primary">Register</button>
</form>
${sessionScope.messageReg}
</body>
</html>
