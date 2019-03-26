package snakes;

import org.junit.Assert;
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
    private Deque<Player> players;


    @Before
    public void initNewGame(){
        john = new Player("John");
        julia = new Player("Julia");
        players = new LinkedList<>();
        players.add(john);
        players.add(julia);
        game = new Game (13, players, 6);
        die = mock(Die.class);
    }

    @Test
    public void testPlayWithMockitoDie(){
        when(die.roll()).thenReturn(3); // John: 1-4-7-10-13
        game.play(die);
        assertTrue("The game is over.", game.isOver());
        assertTrue("John wins.", john.wins());
    }

    @Test
    public void testPlayWithMockDie() {
        MockDie mock = new MockDie(3);
        game.play(mock);
    }

    /**
     * Tests corner case when there is only one player left.
     * This player should win even though he didn't reach
     * the last square.
     *
     * @throws GameNotOverException
     */
    @Test(expected=GameNotOverException.class)
    public void winByBeingLastOneLeft() throws GameNotOverException {
        game.makePlayerLose(john); // takes John out of game and makes Julia the winner
        assertEquals("Julia is assigned winner", julia, game.winner());
    }

}
