/**
 * @author Adrián Rodríguez Bazaga
 * @email arodriba@ull.edu.es
 * @date 23 March 2016
 * @assignment 6
 */

package junittesting;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import gui.LineElement;

import java.awt.Point;

import org.junit.Test;

public class LineElementTest {

  
	/**
	 * Checking that the line creation is working properly.
	 */	
	@Test
	public void testLinePointToPointCreation() {
    final int FIRST_POINT_X_VALUE = 0;
    final int FIRST_POINT_Y_VALUE = 0;
    final int SECOND_POINT_X_VALUE = 2;
    final int SECOND_POINT_Y_VALUE = 1;
    final int THIRD_POINT_X_VALUE = 1;
    final int THIRD_POINT_Y_VALUE = 4;
    final int FOURTH_POINT_X_VALUE = 3;
    final int FOURTH_POINT_Y_VALUE = 5;
    final double EXPECTED_LINES_SLOPE = 0.5;
    final double EXPECTED_LINE1_AND_LINE2_ORIGIN = 0.0;
    final double EXPECTED_LINE3_AND_LINE4_ORIGIN = 3.5;
    
		Point first = new Point (FIRST_POINT_X_VALUE, FIRST_POINT_Y_VALUE);
		Point second = new Point (SECOND_POINT_X_VALUE, SECOND_POINT_Y_VALUE);
		Point third = new Point (THIRD_POINT_X_VALUE, THIRD_POINT_Y_VALUE);
		Point fourth = new Point (FOURTH_POINT_X_VALUE, FOURTH_POINT_Y_VALUE);
		
		LineElement line1 = new LineElement(first, second);
		LineElement line2 = new LineElement(second, first);
		LineElement line3 = new LineElement(third, fourth);
		LineElement line4 = new LineElement(fourth, third);
		
		assertEquals(line1.getSlope(), EXPECTED_LINES_SLOPE, 0);
		assertEquals(line1.getOrigin(), EXPECTED_LINE1_AND_LINE2_ORIGIN, 0);
		
		assertEquals(line2.getSlope(), EXPECTED_LINES_SLOPE, 0);
		assertEquals(line2.getOrigin(), EXPECTED_LINE1_AND_LINE2_ORIGIN, 0);
		
		assertEquals(line3.getSlope(), EXPECTED_LINES_SLOPE, 0);
		assertEquals(line3.getOrigin(), EXPECTED_LINE3_AND_LINE4_ORIGIN, 0);
	
		assertEquals(line4.getSlope(), EXPECTED_LINES_SLOPE, 0);
		assertEquals(line4.getOrigin(), EXPECTED_LINE3_AND_LINE4_ORIGIN, 0);
	}
	
	/**
	 * Checking that the integer evaluation is working properly for the 'y' value
	 */
	@Test
	public void testIntegerEvaluation() {
	  final double LINE_X_VALUE = 0.5;
	  final double LINE_Y_VALUE = 3.5;
	  final int FIRST_EVALUATION_X_VALUE = 2;
	  final int SECOND_EVALUATION_X_VALUE = 1;
	  final int THIRD_EVALUATION_X_VALUE = 3;
	  final int SECOND_EVALUATION_EXPECTED_X_VALUE = 1;
	  final int SECOND_EVALUATION_EXPECTED_Y_VALUE = 4;
	  final int THIRD_EVALUATION_EXPECTED_X_VALUE = 3;
	  final int THIRD_EVALUATION_EXPECTED_Y_VALUE = 5;
	  
		LineElement line = new LineElement(LINE_X_VALUE, LINE_Y_VALUE);
		Point result;
		
		result = line.evaluateLineWithXValue(FIRST_EVALUATION_X_VALUE);
		
		assertTrue(result == null);
		
		result = line.evaluateLineWithXValue(SECOND_EVALUATION_X_VALUE);
		
		assertEquals(result.x, SECOND_EVALUATION_EXPECTED_X_VALUE);
		assertEquals(result.y, SECOND_EVALUATION_EXPECTED_Y_VALUE);
		
		result = line.evaluateLineWithXValue(THIRD_EVALUATION_X_VALUE);
		
		assertEquals(result.x, THIRD_EVALUATION_EXPECTED_X_VALUE);
		assertEquals(result.y, THIRD_EVALUATION_EXPECTED_Y_VALUE);
	}
}
