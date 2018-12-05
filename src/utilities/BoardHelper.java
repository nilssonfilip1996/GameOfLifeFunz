package utilities;

public class BoardHelper {
	public static boolean evaluateCell(int board[][], int c, int r) {
		int counter=0;
		for (int i = -1; i < 2; i++) {
			for (int j = -1; j < 2; j++) {
				if((c+i)<0 || (c+i)>=board.length ||
				   (r+j)<0 || (r+j)>=board.length ||
				   (i==0 && j==0)) {
					//do nothing
				}
				else {
					if(board[c+i][r+j]==1) {
						counter++;
					}
				}
			}
		}
		boolean isAlive = board[c][r]==1;
		if(isAlive) {
			if((counter<2)||counter>3) {
				isAlive = false;
			}
		}
		else {
			if(counter==3) {
				isAlive=true;
			}
		}
		return isAlive;
	}

	public static int[][] get2DArrayCopy(int[][] input) {
		if (input == null)
	        return null;
	    int[][] result = new int[input.length][];
	    for (int r = 0; r < input.length; r++) {
	        result[r] = input[r].clone();
	    }
	    return result;
	}

}
