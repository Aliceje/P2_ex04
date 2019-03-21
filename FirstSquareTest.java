package snakes;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import snakes.squares.Square;
import snakes.squares.FirstSquare;

public class FirstSquareTest {

    private Square firstSquare;
    private Game game;
    private Player john;
    private Player jill;

    @Before
    public void mockGame(){
        game = mock(Game.class);
        when(game.isValidPosition(anyInt())).thenReturn(true);
        firstSquare = new FirstSquare(game, 1);
        john = mock(Player.class);
        jill = mock(Player.class);

    }

    @Test
    public void testLandHereOrGoHome() {
        assertEquals(firstSquare, firstSquare.landHereOrGoHome());
    }

    @Test
    public void testEnter() {
        firstSquare.enter(jill);
        assertEquals("First square is occupied.", true, firstSquare.isOccupied());
    }

    @Test
    public void testLeave() {
        firstSquare.enter(jill); // Jill stored in private ArrayList
        firstSquare.leave(jill);
        assertEquals("First square is empty", false, firstSquare.isOccupied());
    }

    @Test
    public void testToString() {
        String expectedString = "[1<Jill><John>]";
        when(jill.toString()).thenReturn("Jill");
        when(john.toString()).thenReturn("John");
        firstSquare.enter(jill);
        firstSquare.enter(john);
        assertEquals(expectedString, firstSquare.toString());
    }

}
