package rullofx.board.model;

public class Sum {
	private int target;
	private int current;
	/**
	 * @return the target
	 */
	public int getTarget() {
		return target;
	}
	/**
	 * @return the current
	 */
	public int getCurrent() {
		return current;
	}
	/**
	 * @param target
	 */
	public Sum(int target,Array<Cell> cells ) {
		super();
		this.target = target;
		this.current = -1;
	}
	
	
	

	
}
