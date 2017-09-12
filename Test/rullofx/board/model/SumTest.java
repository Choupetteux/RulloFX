package rullofx.board.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SumTest {

    /**
     * Implémentation simple de l'interface Array dans une classe interne.
     */
    private class SimpleCellArray implements Array<Cell> {
        Cell [] data = {new Cell(1), new Cell(2), new Cell(3), new Cell(4)};

        @Override
        public int size() {
            return data.length;
        }

        @Override
        public Cell get(int index) {
            return data[index];
        }        
    }
    
    private SimpleCellArray cells;
    private Sum sum;

    @Before
    public void setUp() throws Exception {
        this.cells = new SimpleCellArray();
        this.sum = new Sum(5, this.cells);
    }

    @Test
    public void update_noInactiveCell() {
    	 sum.update();
        
        // toutes les cellules étant actives, la somme doit valoir 10
        assertEquals(10, sum.getCurrent());
    }
    
    @Test
    public void update_noActiveCell() {
    	for(int i = 0; i < this.cells.size();i++){
    		this.cells.get(i).toggleActiveState();
    	}
    	 sum.update();
        // toutes les cellules étant inactives, la somme doit valoir 0
        assertEquals(0, sum.getCurrent());
    }
    
    @Test
    public void update_someActiveCell() {
    	this.cells.get(0).toggleActiveState();
    	this.cells.get(3).toggleActiveState();
    	 sum.update();
        // toutes les cellules étant inactives, la somme doit valoir 0
        assertEquals(5, sum.getCurrent());
    }
    
}