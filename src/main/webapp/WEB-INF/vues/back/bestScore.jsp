<%@page import="bo.User"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
    content="text/html; charset=windows-1256">
<title>App Game</title>
</head>
<body>

<h1 align="center">Meilleurs scores</h1>
<%
    // On r�cup�re les utilisateurs de la requ�te
    List<User> users = (List<User>) request.getAttribute("users");
    out.print("<table class=\"table\" style=\"background-color: #f2f2f2; padding: 10px;\">");
    out.print("<tr><th>Nom</th><th>Score</th></tr>");
    // On affiche le best score
    for (User it : users) {
        out.print("<tr><td>" + it.getNom() + "</td><td>" + it.getBestScore() + "</td></tr>");
    }
    out.print("</table>");
%>

</body>
</html>
