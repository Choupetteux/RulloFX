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

    /**
     * Indique si la valeur courante est égale à la valeur à atteindre
     * @return vrai si la valeur courante est égale à la valeur à atteindre, faux sinon
     */
    public boolean isTargetReached() {
        return false;
    }
    
    /**
     * Met à jour la somme courante, en ne tenant compte que des cellules actives.
     */
    public void update() {
    }        
    
	
	
	

	
}
