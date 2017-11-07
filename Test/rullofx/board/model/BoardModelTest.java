package rullofx.board.model;

import static org.junit.Assert.*;

import java.util.EnumMap;
import java.util.Observable;
import java.util.Observer;

import org.junit.Before;
import org.junit.Test;

import rullofx.board.model.BoardModelEvent.EventType;

public class BoardModelTest implements Observer {

	BoardDataFactory factory = new SampleBoardDataFactory();
	BoardModel model;
	EnumMap<BoardModelEvent.EventType, BoardModelEvent> receivedEvents;

	@Before
	public void setUp() throws Exception {
		model = new BoardModel(factory);
		receivedEvents = new EnumMap<BoardModelEvent.EventType, BoardModelEvent>(BoardModelEvent.EventType.class);
		model.startGame();
		model.addObserver(this);
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
	
	@Test
	public void testStartGame_startEventFired() {
	    // invocation d'une méthode censée émettre un événement
	    model.startGame();
	    // récupération de l'événement attendu
	    BoardModelEvent event = receivedEvents.get(BoardModelEvent.EventType.START_EVENT);
	    // vérification de sa présence
	    assertNotNull(event);
	 }
	  
	  @Test
	  	public void emissionEvenementType(){
		  
	  }

	@Override
	public void update(Observable o, Object arg) {
		BoardModelEvent event = (BoardModelEvent) arg;
		receivedEvents.put(event.eventType, (BoardModelEvent) arg );
	}
	
	@Test
	public void testEventType_activationEvent(){
		
	}
	  
}
