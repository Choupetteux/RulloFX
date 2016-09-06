/**
 * 
 */
package rullofx.board;

import javafx.scene.layout.GridPane;
import rullofx.board.model.BoardModel;

public class BoardView extends GridPane {
    private BoardController controller = new BoardController(this);
    private BoardModel model;
    
}
