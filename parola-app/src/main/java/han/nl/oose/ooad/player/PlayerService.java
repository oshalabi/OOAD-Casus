package han.nl.oose.ooad.player;

import han.nl.oose.ooad.dummydata.IPlayers;
import han.nl.oose.ooad.dummydata.Players;
import han.nl.oose.ooad.exceptions.PlayerNotFoundException;

import java.util.Arrays;
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
    public boolean checkPlayerCanPlay(String playerName, int quizPrice) {
        return this.getPlayerByName(playerName).getCredits() >= quizPrice;
    }

    @Override
    public void purchaseCredits(String playerName, int _package) {
       Player player = this.getPlayerByName(playerName);
       int credits = player.getCredits();
       player.setCredits(credits + _package);
    }

    @Override
    public int getPlayerCredits(String playerName) {
        return this.getPlayerByName(playerName).getCredits();
    }

    @Override
    public boolean checkPlayerPassword(String password) {
        return this.player.getPassword().equals(password);
    }

    @Override
    public void addPlayer(String playerName, String password) {
        List<Player> temPlayers =  this.players;
        temPlayers.add(new Player(playerName, password, 0, this.defaultAmountCredits));
        this.players = temPlayers;
    }

    @Override
    public Player getPlayerByName(String playerName){
        return  this.players.stream().filter(
                p -> p.getName().equals(playerName)
        ).findFirst().orElse(null);
    }

    @Override
    public int getPlayerScore(String playerName) {
        return this.getPlayerByName(playerName).getScore();
    }


}
