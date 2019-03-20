package snakes.squares;

import snakes.Game;
import snakes.Player;
/**
 * Upon landing on a instantLose square, the current player lose the game.
 * In a two player game, this means that that the player landing on the instantLoseSquare will lose
 * the game and other player win the game immediately.
 */

public class InstantLoseSquare extends StandardSquare {
    /**
     * Initialize with the host game and position in it
     *
     * @param game     game of which this square is a part of, must not be null
     * @param position position of this square in the game, must be >= 1
     */
    public InstantLoseSquare(Game game, int position) {
        super(game, position);
    }

    /**
     * The entering player has lost the game immediately.
     * @param player the player that lands on this square
     */
    @Override
    public void enter(Player player) {
        assert player != null;
        System.out.println(player + " has entered the InstantLoseSquare...");
        game.makePlayerLose(player);
    }

    @Override
    protected String squareLabel() {
        return super.squareLabel() + " (InstantLose)";
    }
}
