/**
 * 
 */
package rullofx.board;

import java.util.Observable;
import java.util.Observer;
import javafx.scene.control.Label;

import javafx.scene.layout.GridPane;
import rullofx.board.model.BoardModel;

public class BoardView extends GridPane implements Observer {
	private BoardController controller = new BoardController(this);
	private BoardModel model = new BoardModel();
	@Override

	public void update(Observable o, Object arg) {
		System.out.print(arg);

	}

	public void setModel(BoardModel model){
		this.model=model;


	}

	public void init(){
	}


	public Class CellView(){
		private int row;
		private int column;
		private Label Text;


		public CellView(int row, int col){
			this.row=row;
			this.column=col;

		}
		
		public void updateActiveState(){
		}
		
		public void updateLockedState(){
		}

	}



}
