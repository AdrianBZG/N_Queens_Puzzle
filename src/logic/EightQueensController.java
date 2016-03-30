package logic;

import gui.EightQueensView;

/**
 * This is the Eight Queens Problem Controller class for the MVC pattern.
 */
public class EightQueensController {
  private EightQueensView view;
  private PositionManager model;
  
  public EightQueensController(EightQueensView view, PositionManager model) {
    this.view = view;
    this.model = model;
  }

  /**
   * Getter for the view
   * @return The view
   */
  private EightQueensView getView() {
    return view;
  }
  
  /**
   * Getter for the model
   * @return The model
   */
  private PositionManager getModel() {
    return model;
  }
  
  /**
   * Tells the view to update using the given model
   */
  public void updateView() {
    getView().showProblemSolution(getModel());
  }
}
