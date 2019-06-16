import java.util.ArrayList;

/**
 * The Constraint Satisfaction Object
 * @author Warren
 *
 */
public class CSP {
	ChessBoard chessBoard;	// ChessBoard object
	int solutions = 0;
	
	CSP(int n){
		chessBoard = new ChessBoard(n);
	}
	
	/**
	 * Main CSP method to solve the N-Queens problem
	 */
	public void solve() {
		
		if (placeQueens(0) == false ) System.out.println("No Solution");
		
		System.out.printf("\nSolutions Found: %d\n", solutions);
		
	}
	
	/**
	 * Recursive function to place the queens.
	 * The problem becomes smaller as queens are placed
	 * on the chessBoard object
	 * @param row
	 */
	public boolean placeQueens(int row) {
		
		// If row == the size of the board assume complete
		if (row == chessBoard.getSize()) {
			printBoard();
			solutions++;
			return true;
		}
			
		boolean result = false;
		
		// If row is where the users queen is
		if (chessBoard.isUsersQueen(row)) {
			// Explore tree, call this recursively
			if (placeQueens(row + 1) == true) return true;
			
		} else {
			
			// Loop through all columns
			for (int col = 0; col < chessBoard.getSize(); col++) {
				/*
				 * If a queen can be placed here than place it.
				 * Now recursively call this function for this 'subtree' of the board
				 */
				if (chessBoard.canPlaceQueen(row, col)) {
					
					chessBoard.placeQueen(row, col);
					
					// Explore tree, call this recursively
					result = placeQueens(row + 1) || result;
					
					// Did not place queen if it got to here
					chessBoard.setEmpty(row, col);
					if (Main.DEBUG) System.out.printf("Failed to place Queen (%d, %d)\n", col, row);
					
				}
			}
			
		}
		
		// If nothing works than return false to backtrack
		return result;
		
	}
	
	/**
	 * Call printBoard on the ChessBoard object
	 */
	public void printBoard() {chessBoard.printBoard();}
	
}
