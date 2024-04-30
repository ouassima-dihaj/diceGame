<%@page import="bo.Message"%>
<%@page import="java.util.*"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>App Game</title>
</head>
<body>

<h1>Page d'erreur</h1>

<ul>
    <% 
        List<Message> messages = (List<Message>) request.getAttribute("messages");
        if(messages != null) {
            for(Message msg : messages) { 
    %>
    <li style="color: red"><%= msg.getText() %></li>
    <% 
            }
        } 
    %>
</ul>

</body>
</html>
