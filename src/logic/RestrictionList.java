/**
 * @author Adrián Rodríguez Bazaga
 * @email arodriba@ull.edu.es
 * @date 23 March 2016
 * @assignment 6
 */

package logic;

import java.awt.Point;
import java.util.ArrayList;

public class RestrictionList {
	private ArrayList<Restrictions> restrictionList;   // Saves the restrictions list
	
	public RestrictionList() {
		restrictionList = new ArrayList<Restrictions>();
	}
	
	private ArrayList<Restrictions> getRestrictionList() {
	  return restrictionList;
	}
	
	/**
	 * This method adds a new restriction to the ArrayList of restrictions
	 * @param restriction The new restriction
	 */
	public void addRestriction(Restrictions restriction)  {
	  getRestrictionList().add(restriction);
	}
	
	/**
	 * This method gets every restriction and calls its disableCells method
	 * to successfully disable the current invalid cells
	 * @param board The logic board
	 * @param cell The position (Of the queens that've been just added)
	 */
	public void applyRestrictions(BoardLogic board, Point cell) {
		for (int i = 0; i < getRestrictionList().size(); i++) {
		  getRestrictionList().get(i).disableCells(board, cell);
		}
	}
}
