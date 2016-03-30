/**
 * @author Adrián Rodríguez Bazaga
 * @email arodriba@ull.edu.es
 * @date 23 March 2016
 * @assignment 6
 */

package logic;

import gui.LineElement;

import java.awt.Point;

public class ModifiedRestrictions extends Restrictions{
  
  /**
   * Here we perform the logic we want to apply to this kind of restriction
   */
	protected void disableCells(BoardLogic board, Point cell) {
		disableLines(board, cell);
	}

	/**
	 * Sets as invalid the lines that the queen draws on the given cell 
	 * with the others queens.
	 * @param cell The queen position
	 */
	private void disableLines(BoardLogic board, Point cell) {
		LineElement line;               // The line we are going to draw
		Point cellToInvalidate;         // The Point of the cell to invalidate
		final int MAX_Y_VALUE = PositionManager.getNumberOfQueens();      // Max Y value for the point to invalidate
		final int MIN_Y_VALUE = 0;      // Min Y value for the point to invalidate
		
		for (int i = 0; i < board.getQueensPoints().size(); i++){
			if (cell != board.getQueensPoints().get(i)) {
				line = new LineElement(cell, board.getQueensPoints().get(i));
			} else {
				continue;
			}
			for (int j = 0; j < PositionManager.getNumberOfQueens(); j++) {
				if ((cellToInvalidate = line.evaluateLineWithXValue(j)) != null) {
					if ((cellToInvalidate.y < MAX_Y_VALUE && cellToInvalidate.y >= MIN_Y_VALUE)) {
						if (board.getCellState(cellToInvalidate) == BoardState.EMPTY) {
							board.setLogicalMatrixState(cellToInvalidate, BoardState.INVALID);
						}
					}
				}
			}
		}
	}
}
