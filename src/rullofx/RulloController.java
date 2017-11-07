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

	
}


