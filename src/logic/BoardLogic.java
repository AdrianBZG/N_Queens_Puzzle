/**
 * @author Adrián Rodríguez Bazaga
 * @email arodriba@ull.edu.es
 * @date 23 March 2016
 * @assignment 6
 */

package logic;

import java.awt.Point;
import java.util.ArrayList;

public class BoardLogic {
	private BoardState[][] boardLogicalMatrix;                                                 // The logical matrix using State design pattern
	private ArrayList<Point> queensPoints;                                                     // Array that stores the queens positions as Points
	private static final int ROWS_AND_COLUMNS_NUMBER = PositionManager.getNumberOfQueens();    // The 'N' number of the problem
	private RestrictionList restrictionList;                                                   // List of the restrictions for the current problem
	private final String INVALID_QUEEN_POSITION_TEXT = "Invalid position for the queen.";
	
	/**
	 * Creates a board with NxN empty cells and
	 * initializes the array with the position of the N queens.
	 */
	public BoardLogic() {
		boardLogicalMatrix = new BoardState[ROWS_AND_COLUMNS_NUMBER][ROWS_AND_COLUMNS_NUMBER];
		queensPoints = new ArrayList<Point>();
		restrictionList = new RestrictionList();
		
		for (int i = 0; i < ROWS_AND_COLUMNS_NUMBER; i++) {
			for (int j = 0; j < ROWS_AND_COLUMNS_NUMBER; j++) {
				boardLogicalMatrix[i][j] = BoardState.EMPTY;
			}
		}
	}
	
	/**
	 * Copy constructor (Sets one BoardLogic from another BoardLogic data)
	 * @param other The BoardLogic to copy the data
	 */
	public BoardLogic(BoardLogic other) {
		boardLogicalMatrix = new BoardState[ROWS_AND_COLUMNS_NUMBER][ROWS_AND_COLUMNS_NUMBER];
		queensPoints = new ArrayList<Point>();
		restrictionList = other.restrictionList;
		
		for (int i = 0; i < ROWS_AND_COLUMNS_NUMBER; i++) {
			for (int j = 0; j < ROWS_AND_COLUMNS_NUMBER; j++) {
				boardLogicalMatrix[i][j] = other.boardLogicalMatrix[i][j];
			}
		}
		for (int i = 0; i < other.getQueensPoints().size(); i++) {
			queensPoints.add(other.getQueensPoints().get(i));
		}
	}
	
	/**
	 * Gets the state of a certain cell on the chessboard
	 * @param cell The Point of the cell we want to get the state
	 * @return The cell state from the logical matrix
	 * @throws ArrayIndexOutOfBoundsException In case element is null
	 */
	public BoardState getCellState(Point cell) throws ArrayIndexOutOfBoundsException {
		try {
			return boardLogicalMatrix[cell.x][cell.y];
		}
		catch(ArrayIndexOutOfBoundsException e) {
			throw new ArrayIndexOutOfBoundsException();
		}
	}

	protected ArrayList<Point> getQueensPoints() {
		return queensPoints;
	}
	
	private BoardState[][] getLogicalMatrix() {
	  return boardLogicalMatrix;
	}

	/**
	 * Returns the number of columns and rows, must be the same (const var)
	 * @return ROWS_AND_COLUMNS_NUMBER
	 */
	public static int getRowsAndColumnsNumber() {
		return ROWS_AND_COLUMNS_NUMBER;
	}

	public void addRestriction(Restrictions newRestriction) {
		restrictionList.addRestriction(newRestriction);
	}
	
	/**
	 * Tries to add a queen at the specified Point on the chessboard
	 * @param cell Queen position
	 * @throws IllegalArgumentException If the position is invalid
	 */
	public void addQueen(Point cell) throws IllegalArgumentException {
		if (getCellState(cell) != BoardState.EMPTY) {
			throw new IllegalArgumentException(INVALID_QUEEN_POSITION_TEXT);
		}	else {
			queensPoints.add(cell);
			disableCells(cell);
			setLogicalMatrixState(cell, BoardState.QUEEN);
		}		
	}
	
	/**
	 * This method changes the state of a specific point in the logical matrix
	 * @param cell The point
	 * @param state The new state
	 * @throws ArrayIndexOutOfBoundsException in case we are out of bounds
	 */
	public void setLogicalMatrixState(Point cell, BoardState state) throws ArrayIndexOutOfBoundsException {
		try {
		  getLogicalMatrix()[cell.x][cell.y] = state;
		}
		catch (ArrayIndexOutOfBoundsException e) {
			throw new ArrayIndexOutOfBoundsException();
		}
	}
	
	/**
	 * Disables the cells where the queen can threat from the given Point
	 * and the ones aligned with this queen and another one. 
	 * @param cell The Point of the queen
	 */
	private void disableCells(Point cell) {
		restrictionList.applyRestrictions(this, cell);
	}
	
	/**
	 * This method represents the chessboard solution as String
	 */
	public String toString() {
	  final String QUEEN_IDENTIFIER = "Q";
	  final String INVALID_CELL_IDENTIFIER = "*";
	  final String EMPTY_CELL_IDENTIFIER = ".";
		String result = "";
		
		for (int i = 0; i < ROWS_AND_COLUMNS_NUMBER; i++) {
			result += i + "\t";
		}
		
		result += "\n";
		
		for (int i = 0; i < ROWS_AND_COLUMNS_NUMBER; i++) {
		  for (int j = 0; j < ROWS_AND_COLUMNS_NUMBER; j++) {
				if (getCellState(new Point(i, j)) == BoardState.INVALID) {
					result += INVALID_CELL_IDENTIFIER;
				}
				else if (getCellState(new Point(i, j)) == BoardState.QUEEN) {
					result += QUEEN_IDENTIFIER;
				}
				else {
					result += EMPTY_CELL_IDENTIFIER;
				}
				
				result += "\t";
			}
			
			result += " " + i + "\n";
		}
		return result;
	}
	
	/**
	 * This method returns the position of all Queens in the solution using
	 * Algebraic Notation
	 * @return result A string with the positions using algebraic notation
	 */
	public String toAlgebraicNotation() {
	  final String QUEEN_IDENTIFIER = "Q";
    String result = "Queens Positions: ";
    
    for (int i = 0; i < ROWS_AND_COLUMNS_NUMBER; i++) {
      for (int j = 0; j < ROWS_AND_COLUMNS_NUMBER; j++) {
        if (getCellState(new Point(i, j)) == BoardState.QUEEN)  {
          if(i != ROWS_AND_COLUMNS_NUMBER - 1) {
            result = result + AlgebraicNotation.getAlgebraicNotation(i, j, QUEEN_IDENTIFIER) + ", ";
          } else {
            result = result + AlgebraicNotation.getAlgebraicNotation(i, j, QUEEN_IDENTIFIER);
          }
        }
      }
    }
    return result;
	}
}
