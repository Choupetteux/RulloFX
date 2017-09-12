package rullofx.board.model;

public class Sum {
	private int target;
	private int current;
	private Array<Cell> cells;
	
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
		this.cells = cells;
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
    	this.current = 0;
    	//Pour chaque cellule
    	for(int i = 0; i < this.cells.size(); i++){
    		//qui sont actives
    		if(this.cells.get(i).isActive()){
    			//Ajouter la valeur de la cellule à la somme courante.
    			this.current = this.current + this.cells.get(i).getValue();
    		}
    	}
    }        
    
	
	
	

	
}
