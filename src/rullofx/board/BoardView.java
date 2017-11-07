/**
 * 
 */
package rullofx.board;

import java.util.Collection;
import java.util.Observable;
import java.util.Observer;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import rullofx.board.model.BoardModel;
import rullofx.board.model.BoardModelEvent;

public class BoardView extends GridPane implements Observer {
	
	private BoardController controller = new BoardController(this);
	private BoardModel model;
	private CellView cellViews[][];
	
	public class CellView extends Label{
		private int row;
		private int column;

		public CellView(int row, int col){
			super("" + model.getValue(row, col));
			this.row=row;
			this.column=col;
			getStyleClass().add("cell");
			getStyleClass().add("active");
			updateActiveState();
			updateLockedState();
			this.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
  		    	  controller.onCellClicked(e,row,col);
  		      }
  		    });
		}
		
		public void updateActiveState(){
			if(!model.isCellActive(row, column)){
				this.getStyleClass().remove("active");
				this.getStyleClass().add("inactive");
			}
			else{
				this.getStyleClass().remove("inactive");
				this.getStyleClass().add("active");
			}
		}
		
		public void updateLockedState(){
			System.out.println("UpdateLockedState : " + this.row + " ; " + this.column);
		}
	}
	
	@Override
	public void update(Observable o, Object arg) {
		System.out.println(arg);
		BoardModelEvent event = (BoardModelEvent) arg;
		switch(event.eventType){
		case START_EVENT:
			this.init();
			break;
		case ACTIVATION_EVENT:
			this.cellViews[event.row][event.column].updateActiveState();
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
		this.cellViews = new CellView[this.model.getRowCount()][this.model.getColumnCount()];
		for(int i = 0; i < this.model.getRowCount(); i++){
			for(int j = 0; j < this.model.getColumnCount(); j++){
				this.cellViews[i][j] = new CellView(i, j);
				this.add(this.cellViews[i][j], j+1, i+1);
			}
		}
		
	}


	



}
