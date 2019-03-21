package snakes.squares;

import snakes.Game;

/**
 * When landing on a speed up square, in his next turn,
 * the player who entered the square moves ahead
 * twice as many moves than he rolled.
 *
 * Extends (@link StandardSquare) class.
 * Overrides (@link StandartSquare#moveAndLand()).
 */
public class SpeedUpSquare extends StandardSquare {

    public SpeedUpSquare(Game game, int position) {
        super(game, position);
    }

    /**
     * Doubles the moves and returns the
     * square to land on accordingly.
     *
     * @param moves the int the player rolled
     * @return the square the player will land on
     */
    @Override
    public Square moveAndLand(int moves) {
        int doubleMoves = moves * 2;
        return super.moveAndLand(doubleMoves);
    }

    /**
     *
     * @return String which marks a speed up square
     */
    @Override
    protected String squareLabel() { return super.squareLabel() + "(SpeedUp)"; }
}
