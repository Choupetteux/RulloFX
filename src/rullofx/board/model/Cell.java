/**
 * 
 */
package rullofx.board.model;

/**
 * @author ribb0001, lege0007
 *
 */
public class Cell {
	
	private int value;
	private boolean active;
	private boolean locked;
	
	/**
	 * @param value Valeur de la cellule
	 * @param active Etat de la cellule
	 * @param locked Etat du verrouillage de la cellule.
	 */
	public Cell(int value, boolean active, boolean locked) {
		super();
		this.value = value;
		this.active = active;
		this.locked = locked;
	}

	/**
	 * @return La valeur de la cellule.
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @return Si la cellule est active.
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * @return Si la cellule est verrouillé.
	 */
	public boolean isLocked() {
		return locked;
	}
    
    /**
     * Inverse l'état d'activation de la cellule. Si la cellule est verrouillée, l'état ne sera pas modifié.
     * @return vrai si l'état a été modifié, faux sinon
     */
    public boolean toggleActiveState() {
        return false;
    }
    
    /**
     * Inverse l'état de verrouillage de la cellule. Si la cellule est désactivée, l'état ne sera pas modifié.
     * @return vrai si l'état a été modifié, faux sinon
     */
    public boolean toggleLockedState() {
        return false;
    }
    
	
}
