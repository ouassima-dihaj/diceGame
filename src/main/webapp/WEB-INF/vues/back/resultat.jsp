<%@ page import="bo.GameState" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h4>Mon meilleur Score </h4>

<%
    GameState gameState = (GameState) request.getSession().getAttribute("gameState");

    if (gameState != null && gameState.getUser() != null) {
        out.print(Math.max(gameState.getUser().getBestScore(), gameState.getUser().getScore()));
    }
%>


<%
    out.print(gameState);
%>

</body>
</html>
