package han.nl.oose.ooad.dummydata;

import han.nl.oose.ooad.player.Player;

import java.util.ArrayList;
import java.util.List;

public class Players implements IPlayers {
    List<Player> players;

    public Players() {
        this.players = new ArrayList<>();
    }

    @Override
    public List<Player> createDummyPlayers() {
        this.players.add(new Player("Test 1", "1234" , 500, false));
        this.players.add(new Player("Test 2", "1234", 1000, false));
        this.players.add(new Player("Test 3", "1234", 200, false));
        this.players.add(new Player("Test 4", "1234", 10, false));
        this.players.add(new Player("Admin", "1234", 10000, true));
        return players;
    }
}
