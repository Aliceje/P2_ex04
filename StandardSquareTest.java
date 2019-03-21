package snakes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import snakes.squares.Square;
import snakes.squares.StandardSquare;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class StandardSquareTest {
	private Game game;
	private Square testSquare;
	private Player jack;
	private Player jill;

	@Before
	public void mockGame() {
		game = mock(Game.class);
		when(game.isValidPosition(anyInt())).thenReturn(true);
		testSquare = new StandardSquare(game, 1);
		jill = mock(Player.class);
		jack = mock(Player.class);
	}

	@Test
	public void testMoveAndLandOnly() {
		Square start, stop;
		start = mock(Square.class);
		stop = mock(Square.class);

		when(game.findSquare(1, 2)).thenReturn(start);
		when(start.landHereOrGoHome()).thenReturn(stop);

		Square destination = testSquare.moveAndLand(2);
		assertEquals(stop, destination);
	}

	@Test(expected=AssertionError.class)
	public void testOnlyOnePlayerOnSquare() throws AssertionError {
		testSquare.enter(jill);
		testSquare.enter(jack);
	}

	@Test(expected=AssertionError.class)
	public void testDifferentPlayerLeaves() throws AssertionError {
		testSquare.enter(jack);
		testSquare.leave(jill);
	}

	@Test
	public void isNotASubSquare() {
		assertEquals("Is not the first square", false, testSquare.isFirstSquare());
		assertEquals("Is not the last square", false, testSquare.isLastSquare());
	}

}
