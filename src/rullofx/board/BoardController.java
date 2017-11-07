/**
 * 
 */
package rullofx.board;

import javafx.scene.input.MouseEvent;

public class BoardController {
    private BoardView boardView;

    public BoardController(BoardView boardView) {
        this.boardView = boardView;
    }
    
    public void onCellClicked(MouseEvent event, int row, int column){
    	this.boardView.getBoardModel().toggleActiveState(row, column);
    }
    
    
}
