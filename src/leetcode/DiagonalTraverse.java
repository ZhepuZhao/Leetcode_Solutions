package leetcode;

public class DiagonalTraverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9},{10,11,12},{13,14,15}};
		int[] result = findDiagonalOrder(matrix);
		for (int i : result) {
			System.out.print(i + " ");
		}
	}
    public static int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[0];
        int m = matrix.length;
        int n = matrix[0].length;
        int[] traverse = new int[m*n];
        int row = 0;
        int col = 0;
        int way_choose = 0;
        int[][] direction = {{-1,1},{1,-1}};
        // direction 0: row step -1 (go up) and col step 1 (go right)
        // direction 1: row step 1 (go down) and col step -1 (go left)
        for (int i = 0; i < traverse.length; i++){
            traverse[i] = matrix[row][col];
            row += direction[way_choose][0];
            col += direction[way_choose][1];
            
            // we must note that the order of the following conditions are very important
            
            if (row >= m) {
                row = m - 1;
                col += 2;
                way_choose = 1 - way_choose;
            }
            if (col >= n) {
                col = n - 1;
                row += 2;
                way_choose = 1 - way_choose;
            }
            if (row < 0){
                row = 0;
                way_choose = 1 - way_choose;
            }
            if (col < 0){
                col = 0;
                way_choose = 1 - way_choose;
            }
                
        }
        return traverse;
        
    }

}
