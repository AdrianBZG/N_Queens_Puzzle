/**
 * @author Adrián Rodríguez Bazaga
 * @email arodriba@ull.edu.es
 * @date 23 March 2016
 * @assignment 6
 */

package logic;

public class AlgebraicNotation {
  private static final int MAX_ROW_NUMBER = PositionManager.getNumberOfQueens();           // Limit number of row on the chessboard
  private static final int MAX_COL_NUMBER = PositionManager.getNumberOfQueens();           // Limit number of column on the chessboard
  private static final int MIN_ROW_NUMBER = 0;                                             // Min number of row on the chessboard
  private static final int MIN_COL_NUMBER = 0;                                             // Min number of column on the chessboard
  private static final String WRONG_ROW_EXCEPTION_TEXT = "Row number can't be greather than 7 or less than 0!";
  private static final String WRONG_COL_EXCEPTION_TEXT = "Column number can't be greather than 7 or less than 0!";
  private static final int ASCII_A_VALUE = 97;  // ASCII code for the 'A' letter
  
  /**
   * This method returns the Algebraic Notation for a certain position on the chessboard
   * 
   * @param row The row in the board
   * @param col The column in the board
   * @param piece The piece name or initial letter
   * @return Algebraic notation of the piece's position on the board
   */
  public static String getAlgebraicNotation(int row, int col, String piece) throws IllegalArgumentException {
    if(col > MAX_COL_NUMBER || col < MIN_COL_NUMBER) {
      throw new IllegalArgumentException(WRONG_COL_EXCEPTION_TEXT);
    }
    else if(row > MAX_ROW_NUMBER || row < MIN_ROW_NUMBER) {
      throw new IllegalArgumentException(WRONG_ROW_EXCEPTION_TEXT);
    }
    return (piece + (char)(ASCII_A_VALUE + col) + String.valueOf(row+1));      // We get the column letter using the ASCII code (from 97+0 to 97+n)
  }
}
