package snakes;

/**
 * A die for rolling random numbers
 */
public class Die implements IDie {
	protected int faces;

	/**
	 * Initialize a new die with given faces
	 * Faces should be > 0
	 */
	public Die(int faces) {
		assert faces > 0;
		this.faces = faces;
	}

	/**
	 * Roll the die and obtain the result
	 *
	 * @return a random number between 1 and faces
	 */
	@Override
	public int roll() {
		int result = 1 + (int) (faces * Math.random());
		assert result >= 1 && result <= faces;
		return result;
	}

	public void setFaces(int faces){
		this.faces = faces;
	}

	public int getFaces(){
		return faces;
	}
}
