
public class Main {

	public static final boolean DEBUG = false;	// For debugging print statements 
	final static int N = 8;						// Number of queens

	public static void main(String[] args) {
		
		CSP nQueens = new CSP(N);
		
		nQueens.solve();
		
	}
	
}
