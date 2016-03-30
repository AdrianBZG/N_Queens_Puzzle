/**
 * @author Adrián Rodríguez Bazaga
 * @email arodriba@ull.edu.es
 * @date 23 March 2016
 * @assignment 6
 */

package gui;

import helpers.ImageHelper;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import logic.BoardLogic;
import logic.BoardState;
import logic.PositionManager;

public class Board extends JPanel {
  
  private BoardLogic board;                                                   // The logical Board of the problem
  private final String WHITE_CELL_IMAGE = "res/whiteCell.png";                // The white cell image resource
  private final String BLACK_CELL_IMAGE = "res/blackCell.png";                // The black cell image resource
  private final String WHITE_QUEEN_IMAGE = "res/whiteQueen.png";              // The white queen image resource
  private final Color WHITE_CELL_COLOR = new Color(255, 206, 158);            // The default white cell color
  private final Color BLACK_CELL_COLOR = new Color(209, 139, 71);             // The default black cell color
  private final BufferedImage WHITE_CELL_ICON = ImageHelper.toColoredBufferedImage(new ImageIcon(WHITE_CELL_IMAGE).getImage()    // The colored white cell BufferedIcon
                                                                                   , WHITE_CELL_COLOR);
  private final BufferedImage BLACK_CELL_ICON = ImageHelper.toColoredBufferedImage(new ImageIcon(BLACK_CELL_IMAGE).getImage()    // The colored black cell BufferedIcon
                                                                                   , BLACK_CELL_COLOR);
  
  private final BufferedImage WHITE_QUEEN_ICON = ImageHelper.toBufferedImage(new ImageIcon(WHITE_QUEEN_IMAGE).getImage());
  private final int IMAGE_SCALE_FACTOR = PositionManager.getNumberOfQueens();           // The scale factor to correctly shows the images on screen
	private final int NUMBER_OF_ROWS_AND_COLUMNS = PositionManager.getNumberOfQueens();   // The number of rows and columns of this problem (The 'N' number)
  
	/**
	 * Constructor for the Board panel
	 */
	public Board() {
		board = new BoardLogic();
		setLayout(new GridLayout(NUMBER_OF_ROWS_AND_COLUMNS, NUMBER_OF_ROWS_AND_COLUMNS));
	}
	 
	/**
	 * Setter for the Board logic
	 * @param newBoard
	 */
	protected void setBoard(BoardLogic newBoard) {
		board = newBoard;
		setLayout(new GridLayout(NUMBER_OF_ROWS_AND_COLUMNS, NUMBER_OF_ROWS_AND_COLUMNS));
		repaint();
	}
	
	/**
	 * Getter for the Board logic
	 * @return The current Board logic
	 */
	private BoardLogic getBoard() {
	  return board;
	}

	/**
	 * Overriding the paintComponent method to correctly paint the images on the window, such as the white cells, the black cells
	 * and the queens
	 */
	@Override
	protected void paintComponent(Graphics g) {
		final int IMAGESIZE = Math.min(this.getWidth(), this.getHeight()) / IMAGE_SCALE_FACTOR;
		super.paintComponent(g);
		
		for (int i = 0; i < NUMBER_OF_ROWS_AND_COLUMNS; i++)  {
			for (int j = 0; j < NUMBER_OF_ROWS_AND_COLUMNS; j++) {
				if (getBoard().getCellState(new Point(i, j)) != BoardState.QUEEN) {
				  if ((i + j) % 2 == 0) {
				    g.drawImage(WHITE_CELL_ICON, i * IMAGESIZE, j * IMAGESIZE, IMAGESIZE, IMAGESIZE, this);
				  } else {
				    g.drawImage(BLACK_CELL_ICON, i * IMAGESIZE, j * IMAGESIZE, IMAGESIZE, IMAGESIZE, this);
				  }
				}
				else {
				  if ((i + j) % 2 == 0) {
				    g.drawImage(WHITE_CELL_ICON, i * IMAGESIZE, j * IMAGESIZE, IMAGESIZE, IMAGESIZE, this);
				    g.drawImage(WHITE_QUEEN_ICON, i * IMAGESIZE, j * IMAGESIZE, IMAGESIZE, IMAGESIZE, this);
				  } else {
				    g.drawImage(BLACK_CELL_ICON, i * IMAGESIZE, j * IMAGESIZE, IMAGESIZE, IMAGESIZE, this);
            g.drawImage(WHITE_QUEEN_ICON, i * IMAGESIZE, j * IMAGESIZE, IMAGESIZE, IMAGESIZE, this);
				  }
				}							
			}
		}
	}
	
	/**
	 * Method that delegates the algebraic notation for the queens positions to the Board logic
	 * @return The algebraic notation as String
	 */
	protected String getAlgebraicNotation() {
	  return getBoard().toAlgebraicNotation();
	}
}
