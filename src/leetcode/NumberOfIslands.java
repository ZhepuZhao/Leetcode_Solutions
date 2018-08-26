package leetcode;

import java.util.*;
public class NumberOfIslands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] grid = {{'1','1','1'}, {'0','1','0'},{'1','0','0'},{'1','0','1'}};
		numIslands(grid);
	}
	  public static int numIslands(char[][] grid) {
		    if (grid == null || grid.length == 0) {
		      return 0;
		    }

		    int nr = grid.length; // number of rows
		    int nc = grid[0].length; // number of columns
		    int num_islands = 0;

		    for (int r = 0; r < nr; ++r) {
		      for (int c = 0; c < nc; ++c) {
		        if (grid[r][c] == '1') {
		          ++num_islands;
		          grid[r][c] = '0'; // mark as visited
		          Queue<Integer> neighbors = new LinkedList<>();
		          neighbors.add(r * nc + c); // current row number * total column number + current column number
		          while (!neighbors.isEmpty()) {
		            int id = neighbors.remove(); // id means: a combination of row and column. usually we cannot store row and column index
		            // at the same time by using id, we can easily store row and column index of the previous island unit 
		            // in a single number.
		            int row = id / nc;
		            int col = id % nc;
		            if (row - 1 >= 0 && grid[row-1][col] == '1') {
		              neighbors.add((row-1) * nc + col);
		              grid[row-1][col] = '0';
		            }
		            if (row + 1 < nr && grid[row+1][col] == '1') {
		              neighbors.add((row+1) * nc + col);
		              grid[row+1][col] = '0';
		            }
		            if (col - 1 >= 0 && grid[row][col-1] == '1') {
		              neighbors.add(row * nc + col-1);
		              grid[row][col-1] = '0';
		            }
		            if (col + 1 < nc && grid[row][col+1] == '1') {
		              neighbors.add(row * nc + col+1);
		              grid[row][col+1] = '0';
		            }
		          }
		        }
		      }
		    }

		    return num_islands;
		  }

}
