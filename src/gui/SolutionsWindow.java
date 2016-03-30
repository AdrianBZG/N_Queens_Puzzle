/**
 * @author Adrián Rodríguez Bazaga
 * @email arodriba@ull.edu.es
 * @date 23 March 2016
 * @assignment 6
 */

package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import logic.BoardLogic;
import logic.PositionManager;

public class SolutionsWindow extends JFrame {
  
  private static final String MILLISECONDS_TEXT = " ms";
  private static final String TIME_TEXT = "Time: ";
  private static final String NUMBER_OF_SOLUTIONS_TEXT = "Number of solutions: ";
  private static final String NO_MORE_SOLUTIONS_TEXT = "There are no more solutions.";
  private static final String TIME_PLACEHOLDER_TEXT = "Time: ? ms";
  private static final String NUMBER_OF_SOLUTIONS_PLACEHOLDER_TEXT = "Number of solutions: ?";
  private static final String QUEENS_POSITIONS_PLACEHOLDER_TEXT = "Queens Positions: ?";
  private static final String INFO_MESSAGE_TITLE = PositionManager.getNumberOfQueens() + " Queens Puzzle Notification";
  private static final int TOP_PANEL_NUMBER_OF_ROWS = 0;
  private static final int TOP_PANEL_NUMBER_OF_COLUMNS = 1;
  
  private static ArrayList<BoardLogic> solutionList;    // The Array to store the solutions
	private static int currentSolutionIndex;              // The index to traverse the solutions list
	private static Board boardPanel;                      // The board panel for the window
	private static ArrayList<Long> executionTimes;        // Array to store each solution execution time
	private static JLabel timeText = new JLabel(TIME_PLACEHOLDER_TEXT);                                // Time text for the execution time
	private static JLabel algebraicNotationText = new JLabel(QUEENS_POSITIONS_PLACEHOLDER_TEXT);       // Text for the Algebraic notation
	private static JLabel numberOfSolutionsText = new JLabel(NUMBER_OF_SOLUTIONS_PLACEHOLDER_TEXT);    // Text for the number of solutions
	
	public SolutionsWindow(PositionManager problem) {
		initializeWindowElements();
		initializeListeners();
		initializeProblem(problem);		
	}
	
	/**
	 * This method adds the individual window elements to the frame
	 */
	private void initializeWindowElements() {
	  JPanel top = new JPanel();
	  boardPanel = new Board();    
    add(boardPanel, BorderLayout.CENTER);
    
    top.setLayout(new GridLayout(TOP_PANEL_NUMBER_OF_ROWS, TOP_PANEL_NUMBER_OF_COLUMNS));
    
    top.add(timeText);
    top.add(algebraicNotationText);
    top.add(numberOfSolutionsText);
    
    add(top, BorderLayout.NORTH);
	}
	
	/**
	 * This method initializes the listeners used in the frame
	 */
	private void initializeListeners() {
	  //Key listener (anonymous inner class)
    addKeyListener(new KeyAdapter() {
      public void keyPressed(java.awt.event.KeyEvent e) {
        SolutionsWindow.showNextSolution();    
      }
    });
    setFocusable(true);
    //
	}
	
	/**
	 * This method initializes the problem and starts the solving method, then saves the solutions and the execution times
	 * @param problem
	 */
	private void initializeProblem(PositionManager problem) {
	  problem.solveProblem();
    solutionList = problem.getSolutionList();
    executionTimes = problem.getExecutionTimesList();
    currentSolutionIndex = 0;
    getNumberOfSolutionsText().setText(NUMBER_OF_SOLUTIONS_TEXT + solutionList.size());
    // Show every solution without stopping
    while(currentSolutionIndex < solutionList.size()) {
      showNextSolution();
    }
    //
	}
	
	/**
	 * This method shows the next solution available in the solution Array
	 */
	protected static void showNextSolution() {
		if (currentSolutionIndex < solutionList.size()) {
		  algebraicNotationText.setText("");
			boardPanel.setBoard(solutionList.get(currentSolutionIndex));
			System.out.println(solutionList.get(currentSolutionIndex));
			timeText.setText(TIME_TEXT + executionTimes.get(currentSolutionIndex).intValue() + MILLISECONDS_TEXT);
			algebraicNotationText.setText(boardPanel.getAlgebraicNotation());
			currentSolutionIndex++;
		}
		else {
			JOptionPane.showMessageDialog(null, NO_MORE_SOLUTIONS_TEXT, INFO_MESSAGE_TITLE, JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	/**
	 * This method is a getter for the number of solutions JLabel attribute
	 * @return numberOfSolutionsText
	 */
	private JLabel getNumberOfSolutionsText() {
	  return numberOfSolutionsText;
	}
}
