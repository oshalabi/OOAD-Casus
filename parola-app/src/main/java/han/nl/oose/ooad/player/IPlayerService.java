package han.nl.oose.ooad.player;

public interface IPlayerService {
    boolean checkPlayerByNameExists(String playerName);
    boolean checkPlayerPassword(String password);
    void addPlayer(String playerName, String password);
}
