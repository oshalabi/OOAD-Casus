package han.nl.oose.ooad.player;


public class Player {
    private final String name;
    private final String password;
    private int credits;
    private int score;

    public  Player(String name, String password, int credits) {
        this.name = name;
        this.password = password;
        this.credits = credits;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getPassword() {
        return password;
    }

    public int getScore() {
        return score;
    }
}
