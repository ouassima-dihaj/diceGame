package bo;

public class User {


    private String nom;

    private String prenom;

    private String login;

    private String password;

    private double score;

    private double bestScore;// of this user

    private int compteurLancer;

    private int nbrDice;
    private int bestDice;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public double getBestScore() {
        return bestScore;
    }

    public void setBestScore(double bestScore) {
        this.bestScore = bestScore;
    }

    public int getCompteurLancer() {
        return compteurLancer;
    }

    public void setCompteurLancer(int compteurLancer) {
        this.compteurLancer = compteurLancer;
    }

    public int getNbrDice() {
        return nbrDice;
    }

    public void setNbrDice(int nbrDice) {
        this.nbrDice = nbrDice;
    }

    public int getBestDice() {
        return bestDice;
    }

    public void setBestDice(int bestDice) {
        this.bestDice = bestDice;
    }

    public User(String nom, String prenom, String login, String password, double score, double bestScore, int compteurLancer) {
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.password = password;
        this.score = score;
        this.bestScore = bestScore;
        this.compteurLancer = compteurLancer;

    }
    public User(String nom, String prenom, String login, String password, double score, double bestScore) {
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.password = password;
        this.score = score;
        this.bestScore = bestScore;

    }

    @Override
    public String toString() {
        return "User{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", score=" + score +
                ", bestScore=" + bestScore +
                ", compteurLancer=" + compteurLancer +
                ", nbrDice=" + nbrDice +
                ", bestDice=" + bestDice +
                '}';
    }
}
