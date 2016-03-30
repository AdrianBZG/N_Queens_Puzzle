/**
 * @author Adrián Rodríguez Bazaga
 * @email arodriba@ull.edu.es
 * @date 23 March 2016
 * @assignment 6
 */

package gui;

import java.awt.Point;

public class LineElement {
  private final static String LINE_ILLEGAL_ARGUMENT_TEXT = "'x' and 'y' can't be the same!";
	private double slopeValue;     // The slope of the line
	private double originValue;    // The origin value of the line
	
	/**
	 * Creates a line.
	 * @param newSlope The line slope
 	 * @param newOrigin Line intercept point (origin)
	 */
	public LineElement(double newSlope, double newOrigin) {
		slopeValue = newSlope;
		originValue = newOrigin;
	}
	
	/**
	 * Creates a line from 'x' to 'y'
	 * @param x First point
	 * @param y Second point
	 */
	public LineElement (Point x, Point y) throws IllegalArgumentException {
		if (x.x == y.x) {
			throw new IllegalArgumentException(LINE_ILLEGAL_ARGUMENT_TEXT);
		}
		slopeValue = ((double)(x.y - y.y)) / ((double)(x.x - y.x));
		originValue = x.y - x.x * slopeValue;
	}
	
	/**
	 * Evaluates the line in a given point 'x'.
	 * If 'y' is not an integer value, returns null
	 * 
	 * @return Point with a given 'x' value
	 */ 
	public Point evaluateLineWithXValue(int x) {
		double y = x * getSlope() + getOrigin();
		
		if ((int)y == y) {
			return new Point(x, (int)y);
		}
		
		return null;
	}
	
	/**
	 * Getter for the line slope
	 * @return The slope
	 */
	public double getSlope() {
		return slopeValue;
	}
	
	/**
	 * Getter for the line origin value
	 * @return The origin value
	 */
	public double getOrigin() {
		return originValue;
	}	
}
