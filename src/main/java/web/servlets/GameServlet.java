package web.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import bo.GameState;
import bo.Message;
import bo.User;
import web.helpers.GameContextManagement;

@WebServlet("/back/GameServlet")
public class GameServlet extends HttpServlet {

    private Random random;
    private static final String ERROR_MESSAGE_NO_DICE_CHOSEN = "iVous devez choisir un dé.";
    private static final String ERROR_MESSAGE_INVALID_DICE_NUMBER = "Le numéro de dé choisi est invalide.";
    private static final String ERROR_MESSAGE_ALREADY_THROWN = "Vous avez déjà lancé le dé n°%d.";
    private static final String INFO_MESSAGE_GAME_OVER = "Game Over";
    private static final String INFO_MESSAGE_DICE_THROWN = "Vous avez lancé le dé n°%d et obtenu le chiffre %d.";
    public GameServlet() {
        this.random = new Random();
    }
    protected void play(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        user.setScore(0);
        GameContextManagement gameContext = GameContextManagement.getInstance(getServletContext());
        GameState gameState = (GameState) session.getAttribute("gameState");
        if (user.getCompteurLancer() < 3 &&	gameState.isGameOver()) {
          
                user.setScore(-1); 
                //gameState.addMessage(new Message(INFO_MESSAGE_GAME_OVER, Message.INFO));
                gameState.setGameOver(true);
           
            getServletContext().getRequestDispatcher("/WEB-INF/vues/back/userHome.jsp").forward(request, response);
            return;
        }



        if (user.getCompteurLancer() == 3) {
            if (!gameState.isGameOver()) {
                gameState.addMessage(new Message(INFO_MESSAGE_GAME_OVER, Message.INFO));

                if (user.getScore() > user.getBestScore()) {
                    user.setBestScore(user.getScore());
                    gameContext.updateScore(user);
                }

                gameState.setGameOver(true);
                gameState.reinit();
            }

            getServletContext().getRequestDispatcher("/WEB-INF/vues/back/userHome.jsp").forward(request, response);
            return;
        }

        String diceNumberParam = request.getParameter("diceNumber");
        if (diceNumberParam == null || diceNumberParam.isEmpty()) {
            gameState.addMessage(new Message(ERROR_MESSAGE_NO_DICE_CHOSEN, Message.ERROR));
            getServletContext().getRequestDispatcher("/WEB-INF/vues/back/userHome.jsp").forward(request, response);
            return;
        }

        int diceNumber;
        try {
            diceNumber = Integer.parseInt(diceNumberParam);
            if (diceNumber < 1 || diceNumber > 3) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            gameState.addMessage(new Message(ERROR_MESSAGE_INVALID_DICE_NUMBER, Message.ERROR));
            getServletContext().getRequestDispatcher("/WEB-INF/vues/back/userHome.jsp").forward(request, response);
            return;
        }

        if (gameState.getDiceResults().containsKey(diceNumber)) {
            gameState.addMessage(new Message(String.format(ERROR_MESSAGE_ALREADY_THROWN, diceNumber), Message.ERROR));
            user.setScore(-1); // Si un dé est lancé plus d'une fois, définissez le score à -1
            gameState.addMessage(new Message(INFO_MESSAGE_GAME_OVER, Message.INFO));
            gameState.setGameOver(true);
            getServletContext().getRequestDispatcher("/WEB-INF/vues/back/userHome.jsp").forward(request, response);
            return;
        }


        user.setCompteurLancer(user.getCompteurLancer() + 1);
        int diceResult;

        try {
            diceResult = random.nextInt(6) + 1;
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        gameState.addMessage(new Message(String.format(INFO_MESSAGE_DICE_THROWN, diceNumber, diceResult), Message.INFO));
        gameState.getDiceResults().put(diceNumber, diceResult);

        List<Integer> diceValues = new ArrayList<>(gameState.getDiceResults().values());

        if (diceValues.get(0) == 6) {
            if (gameState.getDiceResults().size() == 1) {
                user.setScore(0);
            }
            gameState.addMessage(new Message("Le jeu est terminé car le premier dé a donné 6", Message.INFO));
            gameState.setGameOver(true);
            System.out.println("le premier dé a donné 6");
            getServletContext().getRequestDispatcher("/WEB-INF/vues/back/userHome.jsp").forward(request, response);
            return; // Arrêtez l'exécution de la méthode pour éviter de lancer d'autres dés
        }


        if (gameState.getDiceResults().size() == 3) {
            if ((diceValues.get(0) < diceValues.get(1)) && (diceValues.get(1) < diceValues.get(2))) {
                user.setScore(diceValues.get(0) + diceValues.get(1) + diceValues.get(2));
            } else {
                user.setScore(0);
                gameState.addMessage(new Message(INFO_MESSAGE_GAME_OVER, Message.INFO));
                gameState.setGameOver(true);
            }
            if (user.getScore() > user.getBestScore()) {
                user.setBestScore(user.getScore());
                gameContext.updateScore(user);
            }
        }

        session.setAttribute("result", diceResult);
        getServletContext().getRequestDispatcher("/WEB-INF/vues/back/userHome.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        play(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        play(request, response);
    }

}
