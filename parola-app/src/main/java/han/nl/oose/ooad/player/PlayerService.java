package han.nl.oose.ooad.player;

import han.nl.oose.ooad.dummydata.IPlayers;
import han.nl.oose.ooad.dummydata.Players;

import java.util.List;

public class PlayerService implements IPlayerService{

    private final IPlayers dummyPlayers;

    private List<Player> players;
    private Player player;
    private final int defaultAmountCredits = 1000;

    public PlayerService() {
        dummyPlayers = new Players();
        this.players = dummyPlayers.createDummyPlayers();
    }

    @Override
    public boolean checkPlayerByNameExists(String playerName) {
        for (Player player : players) {
            if (player.getName().equals(playerName)) {
                this.player = player;
                 return true;
            }
        }
        return false;
    }

    @Override
    public boolean checkPlayerPassword(String password) {
        return this.player.getPassword().equals(password);
    }

    @Override
    public void addPlayer(String playerName, String password) {
        players.add(new Player(playerName, password, defaultAmountCredits));
    }
}
