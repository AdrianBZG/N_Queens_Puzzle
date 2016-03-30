/**
 * @author Adrián Rodríguez Bazaga
 * @email arodriba@ull.edu.es
 * @date 23 March 2016
 * @assignment 6
 */

package logic;

import java.awt.Point;

public class OriginalRestrictions extends Restrictions{
  /**
   * Here we perform the logic we want to apply to this kind of restriction
   */
	protected void disableCells(BoardLogic board, Point cell) {
			disableRow(board, cell);
			disableColumn(board, cell);
			disableDiagonals(board, cell);
	}
	
	/**
	 * Sets as invalid the rows that the queen threats
	 * @param cell The queen position
	 */
	private void disableRow(BoardLogic board, Point cell){
		for (int i = 0; i < PositionManager.getNumberOfQueens(); i++) {
			board.setLogicalMatrixState(new Point(cell.x, i), BoardState.INVALID);
		}
	}
	
	/**
   * Sets as invalid the columns that the queen threats
   * @param cell The queen position
   */
	private void disableColumn(BoardLogic board, Point cell) {
		for (int i = 0; i < PositionManager.getNumberOfQueens(); i++) {
			board.setLogicalMatrixState(new Point(i, cell.y), BoardState.INVALID);
		}
	}
	
	/**
   * Sets as invalid the diagonals that the queen threats
   * @param cell The queen position
   */
	private void disableDiagonals(BoardLogic board, Point cell) {
		for (int i = 0; i < PositionManager.getNumberOfQueens(); i++) {
			try {
				board.setLogicalMatrixState(new Point(cell.x - i, cell.y - i), BoardState.INVALID);
			}
			catch (ArrayIndexOutOfBoundsException e) {
			  // Nothing to do
			}
			try {
				board.setLogicalMatrixState(new Point(cell.x + i, cell.y + i), BoardState.INVALID);
			}
			catch (ArrayIndexOutOfBoundsException e) {
			  // Nothing to do
			}
			try {
				board.setLogicalMatrixState(new Point(cell.x + i, cell.y - i), BoardState.INVALID);
			}
			catch (ArrayIndexOutOfBoundsException e) {
			  // Nothing to do
			}
			try {
				board.setLogicalMatrixState(new Point(cell.x - i, cell.y + i), BoardState.INVALID);
			}
			catch (ArrayIndexOutOfBoundsException e) {
			  // Nothing to do
			}
		}
	}
}