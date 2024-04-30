<%@page import="bo.Message"%>
<%@page import="java.util.List"%>
<%@page import="bo.GameState"%>
<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
    content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/signin.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/bootstrap.min.css">
    
<title>App Game</title>
</head>

<body>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <form id="login-form" class="form-signin" method="POST"
                    action="${pageContext.request.contextPath}/LoginServlet">
                    <h2 class="mb-3">Login</h2>
                    <div class="mb-3">
                        <label for="email" class="form-label">Email address</label>
                        <input type="email" id="email" name="login" class="form-control" placeholder="Enter your email" required>
                    </div>
                    <div class="mb-3">
                        <label for="password" class="form-label">Password</label>
                        <input type="password" id="password" name="password" class="form-control" placeholder="Enter your password" required>
                    </div>
                    <button type="submit" class="btn btn-primary">Login</button>
                </form>
                <div id="create-account-wrap" class="mt-3">
                    <p>Not a member? <a href="${pageContext.request.contextPath}/UserManagementServlet?create">Create Account</a></p>
                </div>
            </div>
        </div>
        <div class="row justify-content-center mt-3">
            <div class="col-md-6">
                <ul class="list-unstyled">
                    <%
                        List<Message> messages = (List<Message>) request.getAttribute("messages");
                        if (messages != null) {
                            for (Message msg : messages) {
                                String style = "";
                                switch (msg.getType()) {
                                    case Message.WARN:
                                        style = "text-danger";
                                        break;
                                    case Message.INFO:
                                        style = "text-success";
                                        break;
                                    case Message.ERROR:
                                        style = "text-danger";
                                        break;
                                    case Message.SUCCESS:
                                        style = "text-warning";
                                        break;
                                    default:
                                        break;
                                }
                    %>
                    <li class="<%=style%>"><%=msg.getText()%></li>
                    <%
                            }
                        }
                    %>
                </ul>
            </div>
        </div>
    </div>
</body>
</html>
