/**
 * 
 */
package rullofx.board;

import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class BoardController {
    private BoardView boardView;

    public BoardController(BoardView boardView) {
        this.boardView = boardView;
    }
    
    public void onCellClicked(MouseEvent event, int row, int column){
    	if(event.getButton() == MouseButton.PRIMARY){
    		this.boardView.getBoardModel().toggleActiveState(row, column);
    	}
    	if(event.getButton() == MouseButton.SECONDARY){
    		this.boardView.getBoardModel().toggleLockedState(row, column);
    	}
    }
    
    public void onRowSumClicked(MouseEvent event, int row, int column){
    	
    }
    
    
    
}
