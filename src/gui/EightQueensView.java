/**
 * @author Adrián Rodríguez Bazaga
 * @email arodriba@ull.edu.es
 * @date 23 March 2016
 * @assignment 6
 */

package gui;

import javax.swing.JFrame;

import logic.PositionManager;

public class EightQueensView {
  private SolutionsWindow view;               // The view auxiliar panel
  private final int WINDOW_SIZE_X = 410;      // The window X size
  private final int WINDOW_SIZE_Y = 440;      // The window Y size
  private final String WINDOW_TITLE = PositionManager.getNumberOfQueens() + " Queens Puzzle";   // The title for the window
  
  public EightQueensView() {
  }
  
  /**
   * This method shows the problem solution (initialize view + apply its settings)
   * @param model
   */
  public void showProblemSolution(PositionManager model) {
    initializeView(model);
    applyViewSettings();
  }

  /**
   * Getter for the view
   * @return The view
   */
  private SolutionsWindow getView() {
    return view;
  }
  
  /**
   * View initializer, it initializes the view using a SolutionsWindow panel
   * @param model
   */
  private void initializeView(PositionManager model) {
    view = new SolutionsWindow(model);
  }
  
  /**
   * This method applies the desired window (frame) configuration
   */
  private void applyViewSettings() {
    getView().setTitle(WINDOW_TITLE);
    getView().setSize(WINDOW_SIZE_X, WINDOW_SIZE_Y);
    getView().setLocationRelativeTo(null);                        // Center the frame
    getView().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    getView().setResizable(true);
    getView().setVisible(true);
  }
}
