package rullofx.board.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CellTest {

    Cell cell;

    @Before
    public void setUp() throws Exception {
        cell = new Cell(42);
    }

    /**
     * Ce test vérifie le comportement de la méthode toggleActiveState sur une
     * cellule active et dévérouillée.
     */
    @Test
    public void toggleActiveState_activeAndUnlockedCell() {
        boolean returnValue = cell.toggleActiveState();

        // la cellule n'étant pas verrouillée, l'opération doit avoir réussi et
        // la valeur de retour doit donc être vraie
        assertTrue("Valeur de retour incorrecte", returnValue);
        
        // la cellule étant initialement activée, elle doit maintenant être désactivée 
        assertFalse("Etat de la cellule incorrect", cell.isActive());
    }
    
    @Test
    public void toggleActiveState_inactiveCell(){
    	cell.toggleActiveState();
    	assertTrue("La cellule devrait être modifiée",cell.toggleActiveState());
    	assertTrue("La cellule devrait être activée",cell.isActive());
    }
    
    @Test
    public void toggleLockedState_activeAndUnlockedCell(){
    	boolean returnValue = cell.toggleLockedState();

        // la cellule devrait être désormais verrouillée et
        // la valeur de retour doit donc être vraie
        assertTrue("La cellule ne s'est pas verrouillée.", returnValue);
        
        // la cellule étant initialement activée, elle doit maintenant être désactivée 
        assertTrue("Etat de la cellule incorrect", cell.isLocked());
    }
    
    @Test
    public void toggleLockedState_inactiveCell(){
    	cell.toggleActiveState();
    	assertFalse("L'état de la cellule ne devrait pas être modifié",cell.toggleLockedState());
    	assertFalse("La cellule ne devrait pas être verrouillé.",cell.isLocked());
    }
}
