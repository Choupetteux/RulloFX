package rullofx.board.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SampleBoardDataFactoryTest {
	
	BoardData board;
	
	@Before
	public void setUp() throws Exception {
		board = new SampleBoardDataFactory().createBoardData();
	}

	@Test
	public void test_CreateBoardData() {
		assertEquals(3,board.getRowCount());
		assertEquals(3,board.getColumnCount());
		assertEquals(1, board.getColumnSum(0).getTarget());
		assertEquals(10,board.getColumnSum(1).getTarget());
		assertEquals(15,board.getColumnSum(2).getTarget());
		assertNotEquals(2, board.getColumnSum(0).getTarget());
		assertEquals(3, board.getRowSum(0).getTarget());
		assertEquals(6, board.getRowSum(1).getTarget());
		assertEquals(17, board.getRowSum(2).getTarget());
		assertEquals(1, board.getCell(0, 0).getValue());
		assertEquals(2, board.getCell(0, 1).getValue());
		assertEquals(3, board.getCell(0, 2).getValue());
		assertEquals(4, board.getCell(1, 0).getValue());
		assertEquals(5, board.getCell(1, 1).getValue());
		assertEquals(6, board.getCell(1, 2).getValue());
		assertEquals(7, board.getCell(2, 0).getValue());
		assertEquals(8, board.getCell(2, 1).getValue());
		assertEquals(9, board.getCell(2, 2).getValue());
	}

}
