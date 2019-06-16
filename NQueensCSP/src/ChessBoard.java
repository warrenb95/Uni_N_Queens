import java.util.Scanner;

public class ChessBoard {

	String[][] nodes;	// The node/squares of the ChessBaord
	int size;			// The size of the ChessBoard
	int queenRow;
	int queenCol;
	
	public ChessBoard(int n) {
		
		nodes = new String[n][n];
		size = n;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				nodes[i][j] = "-";
			}
		}
		
		// User palces their queen
		placeUserQueen();
		
	}

	private void placeUserQueen() {
		
		Scanner scanner = new Scanner(System.in);
		
		// Get the users col
		System.out.printf("Please Enter the row of your queen (1-%d): ", size);
		queenRow = scanner.nextInt()-1;
		System.out.println();
		
		while (queenRow < 0 || queenRow > size) {
			System.out.printf("Please Enter the row of your queen (1-%d): ", size);
			queenRow = scanner.nextInt()-1;
			System.out.println();
		}
		
		// Get the users row
		System.out.printf("Please Enter the column of your queen (1-%d): ", size);
		queenCol = scanner.nextInt()-1;
		System.out.println();
		
		while (queenCol < 0 || queenCol > size) {
			System.out.printf("Please Enter the column of your queen (1-%d): ", size);
			queenCol = scanner.nextInt()-1;
			System.out.println();
		}
		
		scanner.close();
		
		if (Main.DEBUG) System.out.printf("User queen is nodes[%d][%d] \n" , queenRow, queenCol);
		
		nodes[queenRow][queenCol] = "Q";
	}

	/**
	 * Return the size
	 * @return int size
	 */
	public int getSize() {return size;}

	/**
	 * Check to see if a queen can be placed on the
	 * board at (row,col).
	 * @param row
	 * @param col
	 * @return boolean
	 */
	public boolean canPlaceQueen(int row, int col) {
		
		// Check if this is the users queen
		if (row == queenRow) {
			return false;
		}
		
		if (row == queenRow && col == queenCol) {
			return false;
		}
		
		// Check for horizontal conflicts
		for (int i = 0; i < col; i++) {
			if (nodes[row][i].equals("q") || nodes[row][i].equals("Q")) return false;
		}
		
		// Check vertical conflicts
		for (int i = 0; i < size; i++) {
			if (nodes[i][col].equals("q") || nodes[i][col].equals("Q")) return false;
		}
		
		// Check top left diagonal
		for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			
			if (nodes[i][j].equals("q") || nodes[i][j].equals("Q")) return false;
			
		}
		
		// Check top right diagonal
		for (int i = row, j = col; i >= 0 && j < size; i--, j++) {
			
			if (nodes[i][j].equals("q") || nodes[i][j].equals("Q")) return false;
			
		}
		
		// Check bottom left diagonal
		for (int i = row, j = col; i < size && j >= 0; i++, j--) {
			
			if (nodes[i][j].equals("q") || nodes[i][j].equals("Q")) return false;
			
		}
		
		// Check bottom right diagonal
		for (int i = row, j = col; i < size && j < size; i++, j++) {
			
			if (nodes[i][j].equals("q") || nodes[i][j].equals("Q")) return false;
			
		}
		
		return true;
	}

	/**
	 * Place the queen at (row,col)
	 * @param row
	 * @param col
	 */
	public void placeQueen(int row, int col) {
		
		nodes[row][col] = "q";
		
	}
	
	/**
	 * Set the value to empty at (row,col)
	 * @param row
	 * @param col
	 */
	public void setEmpty(int row, int col) {
		
		nodes[row][col] = "-";
		
	}
	
	public boolean isUsersQueen(int x) {
		if (x == queenRow) return true;
		
		return false;
	}
	
	/**
	 * Print the board
	 */
	public void printBoard() {
		
		System.out.println();
		
		for (int i = 0; i < size; i++) {
			
			for (int j = 0; j < size; j++) {
				
				if (nodes[i][j].equals("q")) {
					System.out.print(" q ");
				} else if (nodes[i][j].equals("Q")) {
					System.out.print(" Q ");
				} else {
					System.out.print(" - ");
				}
				
			}
			
			System.out.println();
			
		}
		
		System.out.println();
		
	}
	
}
