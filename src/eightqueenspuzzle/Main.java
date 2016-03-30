/**
 * @author Adrián Rodríguez Bazaga
 * @email arodriba@ull.edu.es
 * @date 23 March 2016
 * @assignment 6
 */

package eightqueenspuzzle;

import logic.EightQueensController;
import logic.PositionManager;
import gui.EightQueensView;


public class Main {
  final static int NUMBER_OF_QUEENS = 8;
  
	public static void main(String[] args) {
		
	  //Create the model (the Queen position manager)
	  PositionManager model = new PositionManager(NUMBER_OF_QUEENS);
	  
	  //Create the view : to show the frame with the solutions
	  EightQueensView view = new EightQueensView();
	  
	  //Create the controller
	  EightQueensController controller = new EightQueensController(view, model);
	  controller.updateView();
	}
}
