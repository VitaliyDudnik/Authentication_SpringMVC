
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Password</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<jsp:include page="_Header.jsp"/>
<div class="container">
    <div class="row   justify-content-center">
        <div class="col-sm-4">
            <form action="${pageContext.request.contextPath}/users/updatePassword" method="post">
                <div class="mb-3 mt-5">
                    <label class="form-label">Username</label>
                    <input type="text" name="username"   class="form-control" id="username" >
                </div>
                <div class="mb-3 mt-5">
                    <label class="form-label">Current Password</label>
                    <input type="password" name="oldPassword"   class="form-control" id="oldPassword">
                </div>
                <div class="mb-3">
                    <label class="form-label">New Password</label>
                    <input type="password" name="newPassword" class="form-control" id="newPassword" required>
                </div>
                <button type="submit" class="btn btn-primary w-100">Update Password</button>
            </form>
            <div class="alert alert-primary" role="alert">
                <p>${ExistsUsernamePassword}</p>
                <p>${errorPassword}</p>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
