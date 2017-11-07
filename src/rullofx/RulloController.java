package rullofx;

import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;
import rullofx.board.BoardView;
import rullofx.board.model.BoardModel;

public class RulloController {

	@FXML
	StackPane stackPane;

	private BoardView boardView;

	/**
	 * Méthode invoquée automatiquement après la création de l'interface graphique
	 * associée à ce contrôleur.
	 */
	public void initialize() {
		stackPane.getChildren().add(boardView = new BoardView());
		BoardModel model = new BoardModel();
		boardView.setModel(model);
		boardView.getBoardModel().startGame();
	}

	public EventType enumeration=new EventType();
	switch(enumeration){
	case START_EVENT:
		this.boardView.init();
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




public Class CellView(){
	private int row;
	private int column;

	public CellView(int row, int col){
		this.row=row;
		this.column=col;
	}

}*/
}


