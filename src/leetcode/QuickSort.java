package leetcode;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3,8,2,5,1,4,6,7};
		quickSort(arr, 0, 3);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	public static void quickSort(int[] arr, int left, int right) {
		if(left < right) {
			int p = partition(arr, left, right);		
			quickSort(arr, left, p-1);
			quickSort(arr, p+1, right);
		}
	}
	
	public static int partition(int[] arr, int left, int right) {
		int p = left; // choose the pivot
		int i = left + 1; // i indicates the position that the pivot element is going to insert after the for loop
		for (int j = left+1; j <= right; j++) { // j indicates the position to split the partitioned array and unpartitioned part
			if (arr[j] < arr[p]) {
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
				i++;
			}	
		}
		int temp = arr[left];
		arr[left] = arr[i-1];
		arr[i-1] = temp;
		return i-1;
		
	}

}
