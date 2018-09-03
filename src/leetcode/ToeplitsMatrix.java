package leetcode;

public class ToeplitsMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int[][] matrix = {{1,2,3,4},{5,1,2,3},{9,5,1,2}};
		int[][] matrix = {{65,98,57}};
		isToeplitzMatrix(matrix);
	}

	public static boolean isToeplitzMatrix(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;

		for (int i = 0; i < m; i++) {
			int col = 0;
			int row = i;
			while (row < m) {
				if (row + 1 < m) {
					if (matrix[row][col] != matrix[row + 1][col + 1]) {
						return false;
					} else {
						row += 1;
						col += 1;
					}
				} else {
					break;
				}
			}
		}
		for (int i = 1; i < n; i++) {
			int col = i;
			int row = 0;
			while (col < n) {
				if (col + 1 < n) {
					if (matrix[row][col] != matrix[row + 1][col + 1]) {
						return false;
					} else {
						row += 1;
						col += 1;
					}
				} else {
					break;
				}
			}
		}
		return true;
	}

}
