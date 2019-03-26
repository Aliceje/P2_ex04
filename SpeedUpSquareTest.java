package snakes;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import snakes.squares.SpeedUpSquare;
import snakes.squares.StandardSquare;
import snakes.squares.Square;
import java.util.Queue;
import java.util.LinkedList;

public class SpeedUpSquareTest {
    private Square testSquare;
    private Game game;
    private Player john;
    private Player jill;


    @Before
    public void mockGame() {
        game = mock(Game.class);
        when(game.isValidPosition(anyInt())).thenReturn(true);
        testSquare = new SpeedUpSquare(game, 4);
        john = mock(Player.class);
        jill = mock(Player.class);
    }

    @Test
    public void testMoveAndLand() {
        Square stop = new StandardSquare(game, 10);
        when(game.getSquare(10)).thenReturn(stop);
        when(game.findSquare(4, 6)).thenReturn(stop);
        Square destination = testSquare.moveAndLand(3);
        assertEquals("Square to land on is twice the moves away",stop, destination);
    }

    @Test
    public void testToString(){
        assertEquals("Without player", "[4(SpeedUp)]", testSquare.toString());
        when(jill.toString()).thenReturn("Jill");
        testSquare.enter(jill);
        assertEquals("With player", "[4(SpeedUp)<Jill>]", testSquare.toString());
    }

}
