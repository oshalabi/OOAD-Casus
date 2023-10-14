package han.nl.oose.ooad.exceptions;

import han.nl.oose.ooad.player.Player;

import java.util.function.Supplier;

public class PlayerNotFoundException extends Exception {
    public PlayerNotFoundException(String mes) {
        super(mes);
    }
}
