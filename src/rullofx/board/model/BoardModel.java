/**
 * 
 */
package rullofx.board.model;

public class BoardModel {
	BoardData data =null;
	BoardDataFactory boardDataFactory;
	
	public BoardModel(){
		this.boardDataFactory = new SampleBoardDataFactory();
	}

	public int getColumnCount(){
		return this.data.getColumnCount();
		}
	
	public int getColumnTarget (int column){
		return this.data.getColumnSum(column).getTarget();
	}
	
	public int getRowCount(){
	return this.data.getRowCount();	
	}
	
	public int getRowTarget(int row){
		return this.data.getRowSum(row).getTarget();
	}

	public int getValue(int row, int column){
		return this.data.getCell(row,column).getValue();
	
	}
	public boolean isCellActive(int row, int column){
		return this.data.getCell(row,column).isActive();
	}
	public boolean isCellLocked(int row, int column){

		return this.data.getCell(row,column).isLocked();
	}
	
	
	public boolean isColumnTargetReached(int column){
		boolean ok= false;
		if (this.data.getColumnSum(column).getCurrent()==this.getColumnTarget(column)){
			ok=true;
		}
		return ok;
	}

	public boolean isRowTargetReached(int row){
		
		boolean ok= false;
		if (this.data.getRowSum(row).getCurrent()==this.getRowTarget(row)){
			ok=true;
		}
		return ok;
	}
    public boolean isSolved() {
        return false;
    }

    /**
     * Démarre une nouvelle partie.
     */
    public void startGame() {
        // code définitif (pour l'instant) et suffisamment simple pour ne pas nécessiter de tests
        this.data = boardDataFactory.createBoardData();
    }

    /**
     * Réinitialise le plateau (sans changer les données). Les cellules sont toutes activées et dévérouillées.
     */
    public void reset() {
    }

    /**
     * Inverse l'état d'activation d'une cellule. Si la cellule est verrouillée, l'état ne sera pas modifié.
     * Si l'état de la cellule est modifié, les sommes de la ligne et de la colonne auxquelles appartient la
     * cellule sont mises à jour.
     * @param row ligne de la cellule
     * @param column colonne de la cellule
     */
    public void toggleActiveState(int row, int column) {
    }

    /**
     * Inverse l'état de verrouillage d'une cellule. Si la cellule est désactivée, l'état ne sera pas modifié.
     * @param row ligne de la cellule
     * @param column colonne de la cellule
     */
    public void toggleLockedState(int row, int column) {
    }
}
