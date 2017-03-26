package 数组与字符串;

public class MatrixClear {

	/*
	 *  method 1
	 *  myself
	 *  better
	 */
	public void matrixClear(int[][] matrix) {
		
    	if (matrix == null || matrix.length == 0 || matrix[0].length == 0) 
    		return;
    	int col0 = 1, row = matrix.length, col = matrix[0].length;
    	
    	for (int i = 0; i < row; ++i) {
    		if (matrix[i][0] == 0) col0 = 0;
    		for (int j = 1; j < col; ++j)
    			if (matrix[i][j] == 0)
    				matrix[i][0] = matrix[0][j] = 0;
    	}
    	
    	for (int i = row - 1; i >= 0; --i) {
    		for (int j = col - 1; j >= 1; --j)
    			if (matrix[i][0] == 0 || matrix[0][j] == 0)
    				matrix[i][j] = 0;
    		if (col0 == 0) matrix[i][0] = 0;
    	}
    }
	
	/*
	 *  method 2
	 *  author
	 *  not good
	 */
	public void setZeros(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) 
    		return;
		boolean[] row = new boolean[matrix.length];
		boolean[] col = new boolean[matrix[0].length];
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					row[i] = true;
					col[j] = true;
				}
			}
		}
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (row[i] == true || col[j] == true) {
					matrix[i][j] = 0;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		MatrixClear m = new MatrixClear();
		int[][] matrix = {{1, 2, 3, 4},
						  {5, 6, 0, 8},
						  {13, 10,11,12},
						  {0,14,15,16},
						  {17,18,19,20}};
		for (int[] row : matrix) {
			for (int col : row) 
				System.out.printf("%-2d ", col);
			System.out.println();
		}
		System.out.println();
		m.matrixClear(matrix);
		
		for (int[] row : matrix) {
			for (int col : row) 
				System.out.printf("%2d ", col);
			System.out.println();
		}
		
		System.out.println();
		m.setZeros(matrix);
		
		for (int[] row : matrix) {
			for (int col : row) 
				System.out.printf("%2d ", col);
			System.out.println();
		}
	}

}
