package snakes;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import snakes.squares.FirstSquare;
import snakes.squares.Square;
import snakes.squares.StandardSquare;
import snakes.squares.SwapSquare;

public class SwapSquareTest {
    private Game game;
    private Player john, jill;
    private Square testSquare;

    @Before
    public void mockGame() {
        game = mock(Game.class);
        john = mock(Player.class);
        jill = mock(Player.class);
        when(game.isValidPosition(anyInt())).thenReturn(true);
        testSquare = new SwapSquare(game, 7);
    }

    @Test
    public void testLandHereOrGoHome() {
        Square next = new StandardSquare(game, 3);
        when(game.nextPlayer()).thenReturn(john);
        when(game.nextPlayer().position()).thenReturn(3);
        when(game.getSquare(3)).thenReturn(next);

        assertEquals("Lands on next player's square", next, testSquare.landHereOrGoHome());
    }

    @Test
    public void testToString() {
        when(jill.toString()).thenReturn("Jill");
        assertEquals("Without player", "[7 (Swap)]", testSquare.toString());
        testSquare.enter(jill);
        assertEquals("With player", "[7 (Swap)<Jill>]", testSquare.toString());
    }
}
