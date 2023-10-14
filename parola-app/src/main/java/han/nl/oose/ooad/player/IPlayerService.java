package han.nl.oose.ooad.player;


public interface IPlayerService {
    boolean checkPlayerByNameExists(String playerName);
    boolean checkPlayerPassword(String password);
    void addPlayer(String playerName, String password);
    Player getPlayerByName(String playerName);
    int getPlayerScore(String playerName);

    boolean checkPlayerCanPlay(String playerName, int quizPrice);

    void purchaseCredits(String playerName, int _package);

    public int getPlayerCredits(String playerName);
}
