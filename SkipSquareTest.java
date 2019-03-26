package snakes;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import snakes.squares.FirstSquare;
import snakes.squares.Square;
import snakes.squares.StandardSquare;
import snakes.squares.SkipSquare;

public class SkipSquareTest {
    private Game game;
    private Player john, jill;
    private Square testSquare;

    @Before
    public void mockGame() {
        game = mock(Game.class);
        john = mock(Player.class);
        jill = mock(Player.class);
        when(game.isValidPosition(anyInt())).thenReturn(true);
        testSquare = new SkipSquare(game, 6);
    }

    @Test
    public void testLandHereOrGoHome() {
        Square firstSquare = new FirstSquare(game, 1);
        when(game.firstSquare()).thenReturn(firstSquare);

        //Not occupied
        assertEquals("Returns this square", testSquare, testSquare.landHereOrGoHome());
        //Occupied
        testSquare.enter(jill);
        assertEquals("Returns first square", firstSquare, testSquare.landHereOrGoHome());
    }

    @Test
    public void testToString() {
        when(jill.toString()).thenReturn("Jill");
        assertEquals("Without player", "[6 (Skip)]", testSquare.toString());
        testSquare.enter(jill);
        assertEquals("With player", "[6 (Skip)<Jill>]", testSquare.toString());
    }
}
