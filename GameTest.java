package snakes;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import snakes.squares.*;
import java.util.Deque;
import java.util.LinkedList;


public class GameTest {

    private Game game;
    private Die die;
    private Player john;
    private Player julia;
    /**
     *
     *
     *
     */

    @Before
    public void initNewGame(){
        john = mock(Player.class);
        julia = mock(Player.class);
        Deque<Player> players = new LinkedList<>();
        players.add(john);
        players.add(julia);
        game = new Game (12, players, 6);
        die = mock(Die.class);
    }


    @Test
    public void testPlayGameOver(){
        when(john.wins()).thenReturn(true);
        when(julia.wins()).thenReturn(false);
        when(die.roll()).thenReturn(3);
        assertEquals("John is on the fist square.",0, john.position());
        //assertEquals("Julia is on the first square", 1, julia.position());
        game.play(die);
        assertTrue("The game is over.", game.isOver());
    }

    /*
    @Test
    public void testPlayValidDie(){

    }
    */

}
