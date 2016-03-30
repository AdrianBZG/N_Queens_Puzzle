/**
 * @author Adrián Rodríguez Bazaga
 * @email arodriba@ull.edu.es
 * @date 23 March 2016
 * @assignment 6
 */

package junittesting;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;

import java.awt.Point;

import logic.BoardLogic;
import logic.BoardState;
import logic.ModifiedRestrictions;
import logic.OriginalRestrictions;

import org.junit.Test;

public class BoardLogicTest {
  private BoardLogic board;   // The board logic to perform the tests

  @Before
  public void initializeBoard() {
    board = new BoardLogic();
  }
  
  /**
   * Testing if getting a cell state is working properly
   */
	@Test
	public void testGetCellState() {		
	  board.setLogicalMatrixState(new Point(0, 0), BoardState.EMPTY);
		assertEquals(board.getCellState(new Point(0, 0)), BoardState.EMPTY);
	}
	
	/**
   * Testing if the logical matrix handles errors properly (invalid access)
   */
	@Test
	public void testSetLogicalMatrixState() {
	  final String EXPECTED_EXCEPTION_TEXT = "Exception was expected.";
	  final int POINT_X_VALUE = 10;
	  
	  try {
      board.setLogicalMatrixState(new Point(POINT_X_VALUE, 0), BoardState.EMPTY);
      fail(EXPECTED_EXCEPTION_TEXT);
    }
    catch (ArrayIndexOutOfBoundsException e) {
      assertEquals(e.getMessage(), null);
    }
	}
	
	/**
	 * Testing if the queens are positioned correcly and if the restrictions
	 * are applied properly.
	 */
	@Test
	public void testAddQueen() {
	  final String EXPECTED_EXCEPTION_TEXT = "Exception was expected.";
	  final String INVALID_QUEEN_POSITION_TEXT = "Invalid position for the queen.";
	  final int POINT_5_Y_VALUE = 2;
	  final int POINT_6_X_VALUE = 2;
	  final int POINT_8_X_VALUE = 2;
	  final int POINT_8_Y_VALUE = 3;
	  final int POINT_9_X_VALUE = 3;
	  final int POINT_9_Y_VALUE = 2;
	  final int POINT_10_X_VALUE = 2;
	  final int POINT_10_Y_VALUE = 2;
	  final int POINT_11_X_VALUE = 3;
	  final int POINT_11_Y_VALUE = 2;
	  final int POINT_12_X_VALUE = 4;
	  final int POINT_12_Y_VALUE = 2;
	  
		board.addRestriction(new OriginalRestrictions());
		board.addRestriction(new ModifiedRestrictions());
		board.addQueen(new Point(0, 0));
		
		assertEquals(board.getCellState(new Point(0, 0)), BoardState.QUEEN);
		assertEquals(board.getCellState(new Point(0, 1)), BoardState.INVALID);
		assertEquals(board.getCellState(new Point(1, 0)), BoardState.INVALID);
		assertEquals(board.getCellState(new Point(1, 1)), BoardState.INVALID);
		assertEquals(board.getCellState(new Point(1, POINT_5_Y_VALUE)), BoardState.EMPTY);
	
		board.addQueen(new Point(2, 1));
		
		assertEquals(board.getCellState(new Point(POINT_6_X_VALUE, 1)), BoardState.QUEEN);
		assertEquals(board.getCellState(new Point(0, 0)), BoardState.QUEEN);
		assertEquals(board.getCellState(new Point(POINT_8_X_VALUE, POINT_8_Y_VALUE)), BoardState.INVALID);
		assertEquals(board.getCellState(new Point(POINT_9_X_VALUE, POINT_9_Y_VALUE)), BoardState.INVALID);
		assertEquals(board.getCellState(new Point(POINT_10_X_VALUE, POINT_10_Y_VALUE)), BoardState.INVALID);
		assertEquals(board.getCellState(new Point(POINT_11_X_VALUE, POINT_11_Y_VALUE)), BoardState.INVALID);
		assertEquals(board.getCellState(new Point(POINT_12_X_VALUE, POINT_12_Y_VALUE)), BoardState.INVALID);

		try {
			board.addQueen(new Point(0,0));
			fail(EXPECTED_EXCEPTION_TEXT);
		}
		catch (IllegalArgumentException e) {
			assertEquals(e.getMessage(), INVALID_QUEEN_POSITION_TEXT);
		}
		try {
		  final int POINT_X_VALUE = 4;
		  final int POINT_Y_VALUE = 2;
			board.addQueen(new Point(POINT_X_VALUE, POINT_Y_VALUE));
			fail(EXPECTED_EXCEPTION_TEXT);
		}
		catch (IllegalArgumentException e) {
			assertEquals(e.getMessage(), INVALID_QUEEN_POSITION_TEXT);
		}
	}

	/**
   * Testing if the cells are disabling correctly.
   */
	@Test
	public void testDisableCells() {
	  final String EXPECTED_EXCEPTION_TEXT = "Exception was expected.";
    final String INVALID_QUEEN_POSITION_TEXT = "Invalid position for the queen.";
    final int POINT_2_X_VALUE = 2;
    final int POINT_3_Y_VALUE = 3;
    
    board.addRestriction(new OriginalRestrictions());
    board.addRestriction(new ModifiedRestrictions());
    board.addQueen(new Point(0, 0));  
    board.addQueen(new Point(POINT_2_X_VALUE, 1));

    try {
      board.addQueen(new Point(0, POINT_3_Y_VALUE));
      fail(EXPECTED_EXCEPTION_TEXT);
    }
    catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), INVALID_QUEEN_POSITION_TEXT);
    }
	}
}
