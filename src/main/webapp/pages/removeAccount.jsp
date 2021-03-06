
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Remove Account</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-sm-4 mt-5">
            <form action="${pageContext.request.contextPath}/users/removeAccount" method="post">
                <div class="card text-white bg-danger mb-3" style="max-width: 18rem;">
                    <div class="card-header">REMOVE ACCOUNT</div>
                    <div class="card-body">
                        <h5 class="card-title">Complete Account Deletion</h5>
                        <p class="card-text">After you confirm the deletion of your account, all information about you
                            will be completely deleted. Are you sure you want to delete your account?</p>
                    </div>
                </div>
                <button type="submit" class="btn btn-primary">REMOVE</button>
                <a class="btn btn-primary offset-md-3" href="${pageContext.request.contextPath}/users/account" role="button">BACK</a>
            </form>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
