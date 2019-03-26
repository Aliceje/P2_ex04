package snakes;

/**
 * Mocks the behavior of a (@link Die).
 * For use in tests. Allows you to set the number
 * the die returns when it is rolled.
 *
 */
public class MockDie implements IDie {
    private int rolls;

    /**
     * Set the number the MockDie always rolls.
     *
     * @param rolls
     */
    public MockDie(int rolls) {
        assert rolls > 0;
        this.rolls = rolls;
    }

    /**
     * "Rolls" the die.
     * Always returns the set value of instance variable rolls.
     *
     * @return int the rolls that have been set
     */
    public int roll(){
        return rolls;
    }

    /**
     * Works like the constructor but allows you to change
     * the rolls a MockDie rolls after it has been created.
     *
     * @param rolls int the number the die rolls
     */
    public void setRolls(int rolls) {
        assert rolls > 0;
        this.rolls = rolls;
    }
}
