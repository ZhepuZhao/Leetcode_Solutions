package leetcode;

public class FlippingTheImage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] A = {{1,1,0},{1,0,1},{0,0,0}};
		flipAndInvertImage(A);
	}

	public static int[][] flipAndInvertImage(int[][] A) {
		for (int i = 0; i < A.length; i++) {
			int[] cur = A[i];
			int start = 0;
			int end = cur.length - 1;
			while (start < end) {
				cur[start] = cur[start] == 1 ? 0 : 1;
				cur[end] = cur[end] == 1 ? 0 : 1;
				swap(cur, cur[start], cur[end]);
				start++;
				end--;
			}
			cur[start] = cur[start] == 1 ? 0 : 1;
		}
		return A;
	}

	public static void swap(int[] nums, int a, int b) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}

}
