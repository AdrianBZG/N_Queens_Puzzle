/**
 * @author Adrián Rodríguez Bazaga
 * @email arodriba@ull.edu.es
 * @date 23 March 2016
 * @assignment 6
 */

package junittesting;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import logic.AlgebraicNotation;

import org.junit.Test;

public class AlgebraicNotationTest {

  /**
   * Testing if the algebraic notation is returning the correct String
   */
  @Test
  public void testAlgebraicNotationWorkingProperly() {    
    final int ROW_VALUE = 0;
    final int COLUMN_VALUE = 0;
    final String PIECE_IDENTIFIER = "Q";
    final String EXPECTED_RESULT = "Qa1";
    
    String result = AlgebraicNotation.getAlgebraicNotation(ROW_VALUE, COLUMN_VALUE, PIECE_IDENTIFIER);
    assertEquals(result, EXPECTED_RESULT);
  }
  
  /**
   * Testing if the incorrect arguments problem is handled properly
   */
  @Test
  public void testIncorrectArguments() {
    final String EXPECTED_EXCEPTION_TEXT = "Exception was expected.";
    final String WRONG_ROW_EXCEPTION_TEXT = "Row number can't be greather than 7 or less than 0!";
    final int ROW_VALUE = 10;
    final int COLUMN_VALUE = 0;
    final String PIECE_IDENTIFIER = "Q";
    
    try {
      String result = AlgebraicNotation.getAlgebraicNotation(ROW_VALUE, COLUMN_VALUE, PIECE_IDENTIFIER);
      fail(EXPECTED_EXCEPTION_TEXT);
      System.out.println(result);
    }
    catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), WRONG_ROW_EXCEPTION_TEXT);
    }
  }
}
