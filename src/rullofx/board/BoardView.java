/**
 * 
 */
package rullofx.board;

import java.util.Observable;
import java.util.Observer;
import javafx.scene.control.Label;

import javafx.scene.layout.GridPane;
import rullofx.board.model.BoardModel;
import rullofx.board.model.BoardModelEvent;

public class BoardView extends GridPane implements Observer {
	
	private BoardController controller = new BoardController(this);
	private BoardModel model;
	private CellView cellViews;
	
	public class CellView{
		private int row;
		private int column;
		private Label text;

		public CellView(int row, int col){
			this.row=row;
			this.column=col;
			this.text = new Label();
			getStyleClass().add("cell");
			getStyleClass().add("active");
			updateActiveState();
			updateLockedState();
		}
		
		public void updateActiveState(){
			System.out.print("UpdateActiveState : " + this.row + " ; " + this.column);
		}
		
		public void updateLockedState(){
			System.out.print("UpdateLockedState : " + this.row + " ; " + this.column);
		}

	}
	
	@Override
	public void update(Observable o, Object arg) {
		System.out.print(arg);
		BoardModelEvent event = (BoardModelEvent) arg;
		switch(event.eventType){
		case START_EVENT:
			this.init();
			break;
		case ACTIVATION_EVENT:
			
			break;
		case LOCK_EVENT:
			break;
		case REACHED_COLUMN_EVENT:
			
			break;
		case REACHED_ROW_EVENT:
			
			break;
		case SOLVED_EVENT:
			
			break;
		}
	}

	public void setModel(BoardModel model){
		this.model=model;
		if(this.model.countObservers() == 0){
			this.model.addObserver(this);
		}
		else {
			this.model.deleteObserver(this);
		}
	}
	
	public BoardModel getBoardModel(){
		return this.model;
	}

	public void init(){
		
	}


	



}
