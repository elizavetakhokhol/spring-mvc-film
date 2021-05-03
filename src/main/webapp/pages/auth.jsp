<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

<jsp:include page="_header.jsp"/>
<div class="container ">
    <div class="row justify-content-center mt-5">
        <form action="/user/auth" class="w-25" method="post">
            <div class="mb-3">
                <label for="exampleInputEmail2" class="form-label">Login</label>
                <input type="text" name="login" class="form-control" id="exampleInputEmail2" aria-describedby="loginlHelp">
            </div>
            <div class="mb-3">
                <label for="exampleInputPassword1" class="form-label">Password</label>
                <input type="password" name="password" class="form-control" id="exampleInputPassword1">
            </div>
            <button type="submit" class="btn btn-primary">Login</button>
        </form>
        ${sessionScope.messageAuth}
        ${sessionScope.messageW}
        ${sessionScope.messageAuth2}
    </div>
</div>

</body>
</html>


