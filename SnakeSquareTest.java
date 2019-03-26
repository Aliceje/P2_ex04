package snakes;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import snakes.squares.Square;
import snakes.squares.SnakeSquare;
import snakes.squares.LadderSquare;
import snakes.squares.StandardSquare;

public class SnakeSquareTest {
    private Square testSquare;
    private Player john, jill;
    private Game game;

    @Before
    public void mockGame() {
        game = mock(Game.class);
        when(game.isValidPosition((anyInt()))).thenReturn(true);
        testSquare = new SnakeSquare(-5, game, 9);
        john = mock(Player.class);
        jill = mock(Player.class);
    }

    /**
     * Tests whether correct destination square is found.
     */
    @Test
    public void testLandHereOrGoHome() {
        Square stop;
        stop = new StandardSquare(game, 4);
        when(game.getSquare(4)).thenReturn(stop);

        Square destination = testSquare.landHereOrGoHome();
        assertEquals(stop, destination);
    }

    @Test
    public void testToString() {
        String expectedString = "[4<-9]";
        Square stop = new StandardSquare(game, 4);
        when(game.getSquare(4)).thenReturn(stop);
        assertEquals(expectedString, testSquare.toString());
    }

}
