<%@page import="bo.GameState"%>
<%@page import="bo.User"%>
<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
    content="text/html; charset=windows-1256">
    
<title>Game App</title>

</head>
<body>
<div align="center">

    <h1>Lancer des d�s </h1>
    <tr>
    </tr>
    <h4>Utilisateur connect�:
        <% 
            GameState gameState = (GameState) session.getAttribute("gameState");
            if (gameState != null && gameState.getUser() != null) {
                out.print(gameState.getUser().getNom());
            }
        %>
    </h4>
    <p>Entrer le num�ro du d� � lancer puis cliquer sur le bouton</p>
    <form action="${pageContext.request.contextPath}/back/GameServlet" method="POST">
        <p>Numero de d�s : <input type="number" name="diceNumber" required></p>
        <input type="submit" value="Lancer le d�" />
    </form>
</div>

<footer>
    <hr>
    <a href="${pageContext.request.contextPath}/back/bestScore">Meilleur score</a>|
    <a href="${pageContext.request.contextPath}/back/ReinitGameServlet">R�initialiser</a>|
    <a href="${pageContext.request.contextPath}/DeconnectServlet">Se d�connecter</a> |
    </hr>
</footer>

<h4>Mon meilleur score</h4>
<%
    if (gameState != null && gameState.getUser() != null) {
        out.print(Math.max(gameState.getUser().getBestScore(), gameState.getUser().getScore()));
    }
%>

<%
    out.print(gameState);
%>

</body>
</html>
