package snakes.squares;

import snakes.Game;

/**
 * A snake square represents the beginning of a snake.
 *
 * Keeps track of its length and can obtain the destination square in the game.
 * Snakes always move the player backward.
 */
public class SnakeSquare extends LadderSquare {
	/**
	 * Initializes a new snake for the given game.
	 * @param transport length of the snake, must be within the bounds of the game and < 0
	 * @param game host game, must not be null
	 * @param position position of the ladder start in the game
	 */
	public SnakeSquare(int transport, Game game, int position) {
		super(transport, game, position);
	}


	@Override
	protected String squareLabel() {
		return this.destination().position() + "<-" + position;
	}

	/**
	 * Tests whether the transport is within the bounds of the game and < 0.
	 * By having a negative transport, it is not necessary to override the destination()
	 * method from parent LadderSquare.
	 */
	@Override
	protected boolean isValidTransport(int transport) {
		return transport < 0 &&
				game.isValidPosition(position + transport);
	}

}