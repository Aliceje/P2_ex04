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


    // Version with "real" Game works as well, but depends on Game methods
     /*
    @Before
    public void initGame() {
        john = mock(Player.class);
        jill = mock(Player.class);
        Queue<Player> players = new LinkedList<Player>();
        players.add(john);
        players.add(jill);
        game = new Game(12, players, 6);
        testSquare = new SpeedUpSquare(game, 4);
        game.setSquare(4, testSquare);
    }
    */
    /*
    @Test
    public void testMoveAndLand() {
        Square stop = new StandardSquare(game, 10);
        game.setSquare(10, stop);
        Square destination = testSquare.moveAndLand(3);
        assertEquals("Square to land on is twice the moves away",stop, destination);
    }
    */

}
