package leetcode;

public class MaxIncreaseToKeepCitySkyline {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = {{3, 0, 8, 4},{2, 4, 5, 7},{9, 2, 6, 3},{0, 3, 1, 0}};
		maxIncreaseKeepingSkyline(grid);
	}

	public static int maxIncreaseKeepingSkyline(int[][] grid) {
		// find skyline first
		int m = grid.length;
		int n = grid[0].length;
		int[] top_bottom_skyline = new int[n]; // max in each column
		int[] left_right_skyline = new int[m]; // max in each row
		int row_max = 0;
		int col_max = 0;
		int result = 0;
		// row max: left_right_skyline
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] > row_max) {
					left_right_skyline[i] = grid[i][j];
					row_max = grid[i][j];
				}
			}
			row_max = 0;
		}
		for (int j = 0; j < n; j++) {
			for (int i = 0; i < m; i++) {
				if (grid[i][j] > col_max) {
					top_bottom_skyline[j] = grid[i][j];
					col_max = grid[i][j];
				}
			}
			col_max = 0;
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int max = Math.min(left_right_skyline[i], top_bottom_skyline[j]);
				result += (max - grid[i][j] > 0) ? (max - grid[i][j]) : 0;
			}
		}
		return result;
	}
}
