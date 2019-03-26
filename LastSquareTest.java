package snakes;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import snakes.squares.Square;
import snakes.squares.LastSquare;

public class LastSquareTest {
    private Square lastSquare;
    private Game game;
    private Player john;
    private Player jill;

    @Before
    public void mockGame(){
        game = mock(Game.class);
        when(game.isValidPosition(anyInt())).thenReturn(true);
        lastSquare = new LastSquare(game, 12);
        john = mock(Player.class);
        jill = mock(Player.class);
    }

    @Test
    public void testIsLastSquare() {
        assertEquals("Square is the last square", true, lastSquare.isLastSquare());
    }

    @Test
    public void testLandHereOrGoHome() {
        assertEquals(lastSquare, lastSquare.landHereOrGoHome());
    }

    @Test
    public void testEnter() {
        lastSquare.enter(jill);
        assertEquals("Last square is occupied.", true, lastSquare.isOccupied());
    }

}
