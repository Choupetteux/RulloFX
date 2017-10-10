package rullofx.board.model;

public class BoardModelEvent {

	public final int column;
	public final EventType eventType;
	public final int row;
	
	public BoardModelEvent(EventType eventType, int row, int column){
		this.column = column;
		this.row = row;
		this.eventType = eventType;
	}
	
	public BoardModelEvent(EventType eventType){
		this.eventType = eventType;
		this.column = -1;
		this.row = -1;
	}
	
	public enum EventType {
		ACTIVATION_EVENT,
		LOCK_EVENT,
		REACHED_COLUMN_EVENT,
		REACHED_ROW_EVENT,
		START_EVENT,
		SOLVED_EVENT;
	}
	
}
