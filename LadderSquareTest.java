package snakes;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import snakes.squares.Square;
import snakes.squares.LadderSquare;
import snakes.squares.StandardSquare;

public class LadderSquareTest {

    private Square testSquare;
    private Game game;
    private Player john;
    private Player jill;

    @Before
    public void mockGame(){
        game = mock(Game.class);
        when(game.isValidPosition(anyInt())).thenReturn(true);
        testSquare = new LadderSquare(3, game, 2);
        john = mock(Player.class);
        jill = mock(Player.class);
    }

    /**
     * Tests whether correct destination square is found.
     */
    @Test
    public void testLandHereOrGoHome() {
        Square stop;
        stop = new StandardSquare(game, 5);
        when(game.getSquare(5)).thenReturn(stop);

        Square destination = testSquare.landHereOrGoHome();
        assertEquals(stop, destination);
    }

    @Test
    public void testToString() {
        String expectedString = "[2->5]";
        Square stop = new StandardSquare(game, 5);
        when(game.getSquare(5)).thenReturn(stop);
        assertEquals(expectedString, testSquare.toString());
    }


}
