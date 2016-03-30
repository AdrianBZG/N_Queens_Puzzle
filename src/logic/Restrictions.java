/**
 * @author Adrián Rodríguez Bazaga
 * @email arodriba@ull.edu.es
 * @date 23 March 2016
 * @assignment 6
 */

package logic;

import java.awt.Point;

/**
 * This abstract class makes possible to create new Restriction classes easily, each
 * with different restrictions, just using inheritance.
 */
public abstract class Restrictions {
	protected abstract void disableCells(BoardLogic board, Point cell);
}
