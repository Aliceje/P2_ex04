package snakes;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import snakes.squares.*;
import java.util.Deque;
import java.util.LinkedList;


/**
 * Tests the (@link Game#play()) method.
 *
 * Uses two different ways to mock a (@link Die) object:
 * By using Mockito.
 * By using a MockDie class which specifies a certain behavior
 * for a die.
 *
 */
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
        john = new Player("John");
        julia = new Player("Julia");
        Deque<Player> players = new LinkedList<>();
        players.add(john);
        players.add(julia);
        game = new Game (13, players, 6);
        die = mock(Die.class);
    }


    @Test
    public void testPlayGameOver(){
        when(die.roll()).thenReturn(3); // John: 1-4-7-10-13
        game.play(die);
        assertTrue("The game is over.", game.isOver());
        assertTrue("John wins.", john.wins());
    }


    /**
     * Tests corner case when there is only one player left.
     * This player should win even though he didn't reach
     * the last square.
     *
     * @throws GameNotOverException
     */
    @Test(expected=GameNotOverException.class)
    public void winnerButGameNotOver() throws GameNotOverException {
        game.makePlayerLose(john);
        game.winner(); // should throw an exception
    }

    @Test
    public void winByBeingLastOneLeft() {
        game.makePlayerLose(john);
        assertEquals("Julia is current player.", julia, game.currentPlayer());
        game.play(die);
        assertEquals("Julia wins by default.", true, julia.wins());
    }
    /*
    @Test
    public void testPlayValidDie(){

    }
    */

}
