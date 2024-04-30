package bo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class GameState {
    ///donner l'etat de jeux dans une partie
    private User user;
    private int total;
    private boolean gameOver = false;
    private List<Message> messages = new ArrayList<Message>();

    private ArrayList<Integer> dices = new ArrayList<Integer>();;

    Map<Integer,Integer> diceResults = new HashMap< Integer,Integer>();
    public GameState(User user) {
        this.user = user;
    }


// getters and setters for total

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }



// getters and setters for diceResults

    public Map<Integer, Integer> getDiceResults() {
        return diceResults;
    }

    public void setDiceResults(Map<Integer, Integer> diceResults) {
        this.diceResults = diceResults;
    }
//getters ad setter for dices
    public ArrayList<Integer> getDices() {
        return dices;
    }
    public void setDices(ArrayList<Integer> dices) {
        this.dices = dices;
    }
///reniet method
    public void reinit() {
        gameOver = false;
        messages = new ArrayList<Message>();
        this.user.setScore(0);
        user.setCompteurLancer(0);
        diceResults.clear(); // Réinitialiser les résultats des dés
        dices.clear(); // Réinitialiser les lancers de dés
    }


    public void addMessage(Message ms) {
        messages.add(ms);
    }




  //getters and setters for the user
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
//getters and setters for the gameOver
    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }
//getters and setters for the messages
    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public String toString() {
        return "GameState [Score=" + user.getScore() + ", nombre lancers=" + user.getCompteurLancer() + ", messages="
                + messages + "]";
    }
}
