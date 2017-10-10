package rullofx.board.model;

import static org.junit.Assert.*;

import java.util.EnumMap;

import org.junit.Before;
import org.junit.Test;

public class BoardModelTest {

	BoardDataFactory factory = new SampleBoardDataFactory();
	BoardModel model;
	EnumMap<BoardModelEvent.EventType, BoardModelEvent> receivedEvents;

	@Before
	public void setUp() throws Exception {
		model = new BoardModel(factory);
		model.addObserver(this);
		model.startGame();
	}

	@Test
	public void toggleActiveState_inverseEtat(){
		model.toggleActiveState(1,1);
		assertFalse("La case devrait être activée",model.isCellActive(1,1));
		model.toggleActiveState(1,1);
		assertTrue("La case devrait être désactivée",model.isCellActive(1,1));

	}
	@Test 
	public void toggleActiveState_CalculFait(){
		
	}
	
	@Test
	public void toggleLockedStated_inverseLock(){
		model.toggleLockedState(0,1);
		assertTrue("La case devrait être bloquée",model.isCellLocked(0,1));
		model.toggleLockedState(0,1);
		assertFalse("La case ne devrait pas être bloquée",model.isCellLocked(0,1));
	}
	 
	@Test
	public void isSolved_solved(){
		assertFalse("La grille ne devrait pas être résolue", model.isSolved());
		model.toggleActiveState(1, 0);
		model.toggleActiveState(2, 0);
		model.toggleActiveState(0, 2);
		model.toggleActiveState(1, 1);
		assertTrue("La grille devrait être résolue mais ne l'est pas", model.isSolved());
	}
	
	@Test
	public void reset_isReset(){
		model.toggleActiveState(1, 0);
		model.toggleActiveState(2, 0);
		model.reset();
		assertTrue("La cellule devrait être réactivé après un reset", model.isCellActive(1, 0));
		assertTrue("La cellule devrait être réactivé après un reset", model.isCellActive(2, 0));
	}
	
}