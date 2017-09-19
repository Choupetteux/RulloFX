package rullofx.board.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BoardDataTest {

    BoardData data;
    
    @Before
    public void setUp() throws Exception {
        data = new BoardData(3, 3);
        
    }

    @Test
    public void initCell() {
    	data.initCell(2, 2, 8);
    	assertFalse("La cellule n'est pas correcte",(data.getCell(2, 2).getValue() == 9));
    	assertTrue("La cellule est correcte",(data.getCell(2, 2).getValue() == 8));
    		
    	}

    @Test
    public void initColumnSum() {
    	data.initCell(2, 2, 8);
    	data.initCell(1, 2, 3);
    	data.initCell(0, 2, 0);
    	data.initColumnSum(2, 11);
    	assertTrue((data.getColumnSum(2).getCurrent() == 11));
    	assertFalse((data.getColumnSum(2).getCurrent() != 11));
    	assertTrue((data.getColumnSum(2).getTarget() == 11));
    }

    @Test
    public void initRowSum() { 
        fail("Test pas encore implémenté");
    }
}