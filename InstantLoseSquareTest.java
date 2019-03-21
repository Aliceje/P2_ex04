package snakes;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import snakes.squares.Square;
import snakes.squares.InstantLoseSquare;

public class InstantLoseSquareTest {

    private Square testSquare;
    private Game game;
    private Player john;
    private Player jill;

    @Before
    public void mockGame(){
        game = mock(Game.class);
        when(game.isValidPosition(anyInt())).thenReturn(true);
        testSquare = new InstantLoseSquare(game, 6);
        john = mock(Player.class);
        jill = mock(Player.class);
    }

    /**
     * Make sure the player leaves after entering.
     */
    


}
