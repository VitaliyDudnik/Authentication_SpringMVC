
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Authorization</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<jsp:include page="_Header.jsp"/>
<div class="container">
    <div class="row   justify-content-center">
        <div class="col-sm-4">
            <form action="<%request.getContextPath();%>/users/authorization" method="post">
                <div class="mb-3 mt-5">
                    <label class="form-label">Username</label>
                    <input type="text" name="username"   class="form-control" id="Username">

                </div>
                <div class="mb-3">
                    <label class="form-label">Password</label>
                    <input type="password" name="password" class="form-control" id="Password">
                </div>
                <button type="submit" class="btn btn-primary w-100">Sign in</button>
            </form>
                <div class="alert alert-primary" role="alert">
                    <p>${ExistsUsernamePassword}</p>
                    <p>${errorAuthorization}</p>
                    <p>${reLoginPass}</p>
                    <p>${reLoginUsername}</p>
                </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
