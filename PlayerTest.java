package snakes;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import snakes.squares.Square;
import snakes.squares.StandardSquare;

public class PlayerTest {
    private Game game;
    private Player john, jill;
    private Square firstSquare, squareJohn, squareJill;

    @Before
    public void mockGame() {
        game = mock(Game.class);
        john = new Player("John");
        jill = new Player("Jill");
        squareJohn = mock(StandardSquare.class);
        squareJill = mock(StandardSquare.class);
        firstSquare = mock(StandardSquare.class);
    }

    @Test
    public void testJoinGame() {
        when(game.firstSquare()).thenReturn(firstSquare);

    }

    @Test
    public void testMoveForward() {

    }



}
