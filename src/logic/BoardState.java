/**
 * @author Adrián Rodríguez Bazaga
 * @email arodriba@ull.edu.es
 * @date 23 March 2016
 * @assignment 6
 */

package logic;

/**
 * This enum has the possible cell states for the chessboard logical matrix
 * EMPTY = A queen can be positioned on that cell
 * QUEEN = A queen is positioned on that cell
 * INVALID = Can't position a queen on that cell cause another queen threats it
 */
public enum BoardState {
	EMPTY, QUEEN, INVALID;
}