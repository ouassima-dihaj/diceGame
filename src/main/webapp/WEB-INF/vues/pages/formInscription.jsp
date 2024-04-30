<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/signin.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/bootstrap.min.css">
    <title>App Game</title>
</head>
<body class="body">
    <div id="login-form-wrap" class="form-signin">
        <h2 class="form-signin-heading">Inscription</h2>
        <form id="login-form" class="form-signin" method="post" action="${pageContext.request.contextPath}/UserManagementServlet">
            <input type="hidden" name="action" value="create">
            <p>
                <input type="text" id="username" name="nom" class="form-control" placeholder="Nom" required>
            </p>
            <p>
                <input type="email" id="email" name="login" class="form-control" placeholder="Login" required>
            </p>
            <p>
                <input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
            </p>
            <p>
                <input type="password" id="confirm-password" name="password" class="form-control" placeholder="Confirm Password" required>
            </p>
            <p>
                <input type="submit" id="create-account" class="btn btn-lg btn-primary btn-block" value="Create Account">
            </p>
        </form>
        <div id="create-account-wrap">
            <p>Merci pour votre inscription !</p>
        </div>
    </div>
</body>
</html>
