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
     * cellule active et déverrouillée.
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
    
    /** Essayer d'activer une cellule inactive */
    @Test
    public void toggleActiveState_inactiveCell(){
    	cell.toggleActiveState();
    	assertTrue("La cellule devrait être modifiée",cell.toggleActiveState());
    	assertTrue("La cellule devrait être activée",cell.isActive());
    }
    
    /** Essayer de désactiver une cellule verrouillée */
    @Test
    public void toggleActiveState_activeAndLockedCell(){
    	cell.toggleLockedState();
    	boolean returnValue = cell.toggleActiveState();
    	assertFalse("L'état de la cellule ne devrait pas être modifiable", returnValue);
    	assertTrue("La cellule devrait toujours être active", cell.isActive());
    }
    
    /** Essayer de verrouiller une cellule active */
    @Test
    public void toggleLockedState_activeAndUnlockedCell(){
    	boolean returnValue = cell.toggleLockedState();

        // la cellule devrait être désormais verrouillée et
        // la valeur de retour doit donc être vraie
        assertTrue("La cellule ne s'est pas verrouillée.", returnValue);
        
        // la cellule étant initialement activée, elle doit maintenant être désactivée 
        assertTrue("Etat de la cellule incorrect", cell.isLocked());
    }
    
    /** Essayer de verrouiller une cellule inactive */
    @Test
    public void toggleLockedState_inactiveCell(){
    	cell.toggleActiveState();
    	assertFalse("L'état de la cellule ne devrait pas être modifié",cell.toggleLockedState());
    	assertFalse("La cellule ne devrait pas être verrouillé.",cell.isLocked());
    }
    
    /** Essayer de déverrouiller une cellule verrouillée. */
    @Test
    public void toggleLockedState_lockedCell(){
    	cell.toggleLockedState();
    	boolean returnValue = cell.toggleLockedState();
    	assertTrue("L'état de la cellule n'a pas pu être modifié", returnValue);
    	assertFalse("La cellule n'est pas déverrouillée", cell.isLocked());
    }
  
}
