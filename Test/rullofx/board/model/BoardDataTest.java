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
    	assertEquals(11, data.getColumnSum(2).getCurrent(), 1e-15);
    	assertEquals(11, data.getColumnSum(2).getCurrent(), 1e-15);
    	assertEquals(11, data.getColumnSum(2).getTarget(), 1e-15);
    }

    @Test
    public void initRowSum() { 
    	data.initCell(0, 2, 8);
    	data.initCell(0, 1, 3);
    	data.initCell(0, 0, 0);
    	data.initRowSum(0, 11);
    	assertEquals(11, data.getRowSum(0).getCurrent(), 1e-15);
    	assertEquals(11, data.getRowSum(0).getCurrent(), 1e-15);
    	assertEquals(11, data.getRowSum(0).getTarget(), 1e-15);
    }
}