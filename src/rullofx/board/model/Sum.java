package rullofx.board.model;

import java.util.EnumMap;

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
		this.update();
	}

    /**
     * Indique si la valeur courante est égale à la valeur à atteindre
     * @return vrai si la valeur courante est égale à la valeur à atteindre, faux sinon
     */
    public boolean isTargetReached() {
        if(this.target == this.current){
        	return true;
        }
        else{
        	return false;
        }
    }
    
    /**
     * Met à jour la somme courante, en ne tenant compte que des cellules actives.
     */
    public void update() {
    //Ajouter évènement reçu à l'EnumMap receivedEvents	--A REVOIR
    	EnumMap<EventType<cle>> receivedEvents=EnumMap<EventType>;
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
