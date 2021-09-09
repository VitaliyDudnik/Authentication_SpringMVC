
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>noRegistration</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">

</head>
<body>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-7 mt-5">
            <div class="card text-white bg-dark mb-3" style="width: 35rem;">
                <div class="card-body ">
                    <p class="card-text">As you now understand, something went wrong.
                        To use this page you need to sing in or register.
                        Please choose the link you need. </p>
                    <a href="${pageContext.request.contextPath}/users/authorization" class="card-link">Sign in</a>
                    <a href="${pageContext.request.contextPath}/users/reg" class="card-link">Join us</a>
                    <a href="${pageContext.request.contextPath}/users/home" class="card-link">Back to home page</a>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"
        crossorigin="anonymous"></script>
</body>
</html>
