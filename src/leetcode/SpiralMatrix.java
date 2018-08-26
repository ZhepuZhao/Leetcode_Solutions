package leetcode;

import java.util.*;

public class SpiralMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		int[][] matrix = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
		System.out.println(spiralOrder(matrix));
		
	}

	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<Integer>();
		if (matrix.length == 0)
			return result;
		int m = matrix.length;
		int n = matrix[0].length;

		int left_border = -1;
		int right_border = n;
		int top_border = -1;
		int bottom_border = m;
		int row = 0;
		int col = 0;
		int[][] direction = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		int way_choose = 0;
		for (int i = 0; i < m * n; i++) {
			result.add(matrix[row][col]);
			row += direction[way_choose][0];
			col += direction[way_choose][1];
			if (col >= right_border) {
				row++;
				col--;
				way_choose++;
				way_choose = way_choose % 4;
				top_border++;
			}
			if (row >= bottom_border) {
				col--;
				row--;
				way_choose++;
				way_choose = way_choose % 4;
				right_border--;
			}
			if (col <= left_border) {
				row--;
				col++;
				way_choose++;
				way_choose = way_choose % 4;
				bottom_border--;
			}

			if (row <= top_border) {
				col++;
				row++;
				way_choose++;
				way_choose = way_choose % 4;
				left_border++;
			}
		}
		return result;
	}

}

