package han.nl.oose.ooad.player;


public class Player {
    private String name;
    private String password;
    private int credits;
    private int score;

    public  Player(String name, String password, int score, int credits) {
        this.name = name;
        this.password = password;
        this.credits = credits;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "Player{name='" + name + "', credits=" + credits + "}";
    }

    public int getScore() {
        return score;
    }
}
