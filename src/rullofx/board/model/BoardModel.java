/**
 * 
 */
package rullofx.board.model;

import java.util.Observable;

public class BoardModel extends Observable {
	BoardData data =null;
	BoardDataFactory boardDataFactory;

	public BoardModel(){
		this.boardDataFactory = new SampleBoardDataFactory();
	}

	public BoardModel(BoardDataFactory factory) {
		this.boardDataFactory= factory;
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
			this.setChanged();
			this.notifyObservers(new BoardModelEvent(BoardModelEvent.EventType.REACHED_COLUMN_EVENT));
		}
		return ok;
	}

	public boolean isRowTargetReached(int row){

		boolean ok= false;
		if (this.data.getRowSum(row).getCurrent()==this.getRowTarget(row)){
			ok=true;
			this.setChanged();
			this.notifyObservers(new BoardModelEvent(BoardModelEvent.EventType.REACHED_ROW_EVENT));
		}
		return ok;
	}
	
	
	public boolean isSolved() {
		boolean res = true;
		for(int i = 0; i < this.data.getColumnCount(); i++){
			if (this.data.getColumnSum(i).getCurrent() != this.data.getColumnSum(i).getTarget()) {
				res = false;
			}
		}
		for(int j = 0; j < this.data.getRowCount(); j++){
			if (this.data.getRowSum(j).getCurrent() != this.data.getRowSum(j).getTarget()){
				res = false;
			}
		}
		if(res == true){
			this.setChanged();
			this.notifyObservers(new BoardModelEvent(BoardModelEvent.EventType.SOLVED_EVENT));
		}
		return res;
	}

	/**
	 * Démarre une nouvelle partie.
	 */
	 public void startGame() {
	        data = boardDataFactory.createBoardData();

	        // marque le modèle comme ayant changé
	        this.setChanged();
	        
	        // émission d'un événement à destination des observateurs du modèle
	        this.notifyObservers(new BoardModelEvent(BoardModelEvent.EventType.START_EVENT));
	    }

	/**
	 * Réinitialise le plateau (sans changer les données). Les cellules sont toutes activées et dévérouillées.
	 */
	public void reset() {
		for(int i = 0; i < this.data.getColumnCount(); i++){
			for(int j = 0; j < this.data.getRowCount(); j++){
				this.data.getCell(j, i).toggleActiveState();
				this.data.getColumnSum(i).update();
				this.data.getRowSum(j).update();
			}
		}
	}

	/**
	 * Inverse l'état d'activation d'une cellule. Si la cellule est verrouillée, l'état ne sera pas modifié.
	 * Si l'état de la cellule est modifié, les sommes de la ligne et de la colonne auxquelles appartient la
	 * cellule sont mises à jour.
	 * @param row ligne de la cellule
	 * @param column colonne de la cellule
	 */
	public void toggleActiveState(int row, int column) {
		if(this.data.getCell(row,column).toggleActiveState()){
			this.data.getRowSum(row).update();
			this.data.getColumnSum(column).update();
			this.setChanged();
			this.notifyObservers(new BoardModelEvent(BoardModelEvent.EventType.ACTIVATION_EVENT));
		}
		
	}

	/**
	 * Inverse l'état de verrouillage d'une cellule. Si la cellule est désactivée, l'état ne sera pas modifié.
	 * @param row ligne de la cellule
	 * @param column colonne de la cellule
	 */
	public void toggleLockedState(int row, int column) {
		if(this.data.getCell(row,column).toggleLockedState()){
		this.setChanged();
		this.notifyObservers(new BoardModelEvent(BoardModelEvent.EventType.LOCK_EVENT));
		}
	}
}
