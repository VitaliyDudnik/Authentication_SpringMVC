
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update username</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<jsp:include page="_Header.jsp"/>
<div class="container">
    <div class="row   justify-content-center">
        <div class="col-sm-4">
            <form action="${pageContext.request.contextPath}/users/updateUsername" method="post">
                <div class="mb-3 mt-5">
                    <label class="form-label">New username</label>
                    <input type="text" name="newUsername"   class="form-control" id="Username" required>
                </div>
                <div class="mb-3 mt-5">
                    <label class="form-label">Username</label>
                    <input type="text" name="username"   class="form-control" id="newUsername">
                </div>
                <div class="mb-3">
                    <label class="form-label">Password</label>
                    <input type="password" name="password" class="form-control" id="Password">
                </div>
                <button type="submit" class="btn btn-primary w-100">Update username</button>
            </form>
            <div class="alert alert-primary" role="alert">
                <p>${ExistsUsernamePassword}</p>
                <p>${errorUsernameUpdate}</p>
            </div>
        </div>
    </div>
</div>




<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
