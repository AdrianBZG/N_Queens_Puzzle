/**
 * @author Adrián Rodríguez Bazaga
 * @email arodriba@ull.edu.es
 * @date 23 March 2016
 * @assignment 6
 */

package logic;

import java.awt.Point;
import java.util.ArrayList;

import clock.Clock;

/**
 * This class is the model for our N Queens Problem
 */
public class PositionManager {
	private BoardLogic chessBoardLogic;            // The logical board using the State design pattern
	private ArrayList<BoardLogic> solutionList;    // The array that stores the solutions
	private ArrayList<Long> executionTimesList;    // Array that stores the execution time of each solution
	private Clock timerClock;                      // Clock used to measure the execution time of each solution
	static private int numberOfQueens = 8;         // The N value, initialized at 8, but can we changed if we use the constructor with 1 parameter
	
	public PositionManager() {
	}
	
	public PositionManager(int numberOfQueens) {
	  PositionManager.numberOfQueens = numberOfQueens;
  }
	
	/**
	 * Getter for the number of expected queens
	 * @return The number of expected queens
	 */
	public static int getNumberOfQueens() {
	  return numberOfQueens;
	}
	
	/**
   * Getter for the timer clock
   * @return The timer clock
   */
  public Clock getTimerClock() {
    return timerClock;
  }
	
	/**
	 * This method initializes the problem solving
	 */
	public void solveProblem() {
	  //Initialization
	  initializeStructuresForProblem();
	  setRestrictionsForProblem();
    //
    
    //Solving recursively
	  getTimerClock().start();
		computeNextQueenPosition(chessBoardLogic);
		//
	}
	
	/**
	 * Initialize every structure used in the problem
	 */
	private void initializeStructuresForProblem() {
	  chessBoardLogic = new BoardLogic();
    solutionList = new ArrayList<BoardLogic>();
    executionTimesList = new ArrayList<Long>();
    timerClock = new Clock();
	}
	
	/**
	 * Getter for the board logic
	 * @return The board logic
	 */
	private BoardLogic getBoardLogic() {
	  return chessBoardLogic;
	}
	
	/**
	 * This method activates/adds the restrictions to the problem
	 */
	private void setRestrictionsForProblem() {
	  getBoardLogic().addRestriction(new OriginalRestrictions()); 
	  getBoardLogic().addRestriction(new ModifiedRestrictions());
  }

	/**
	 * This method computes the next solution, using recursive calls to
	 * compute the 'n' next solutions until it finishes with every one
	 * @param boardToComplete The board to be filled with queens
	 */
	private void computeNextQueenPosition(BoardLogic boardToComplete) {
		BoardLogic newBoard;
		
		if (boardToComplete.getQueensPoints().size() == getNumberOfQueens()) {
			getSolutionList().add(boardToComplete);
			getTimerClock().save();
			getExecutionTimesList().add(timerClock.elapsedTime());
		}
		else {
			for (int i = 0; i < getNumberOfQueens(); i++) {
				try {
					newBoard = new BoardLogic(boardToComplete);
					newBoard.addQueen(new Point(boardToComplete.getQueensPoints().size(), i));
					computeNextQueenPosition(newBoard);    // Recursive call
				}
				catch (IllegalArgumentException e) {
					// Nothing to do
				}			
			}			
		}
	}
	
	/**
	 * Getter for the Array of solutions
	 * @return The array of current solutions
	 */
	public ArrayList<BoardLogic> getSolutionList() {
		return solutionList;
	}
	
  /**
   * Getter for the Array of execution times for each solution
   * @return The array of current execution times for each solution
   */
	public ArrayList<Long> getExecutionTimesList() {
		return executionTimesList;
	}
}
