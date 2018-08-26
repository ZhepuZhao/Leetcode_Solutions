package leetcode;

import java.util.*;
public class FindKCloestElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,4,5};
		int k = 4;
		int x = 3;
		List<Integer> list = findClosestElements(arr, k, x);
		int temp = 0;
	}
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        // Binary search solution
        List<Integer> result = new ArrayList<Integer>();
        if (arr == null || arr.length == 0) return result;
        if (k == arr.length) {
            for (int i : arr) {
                result.add(i);
            }
            return result;
        }
        int index = Arrays.binarySearch(arr, x);
        if (index < 0) {
            index = -index - 1;
        }
        int left = Math.max(0, index - k), right = Math.min(arr.length - 1, index + k);
        while (right - left > k - 1) {
            if ( (x - arr[left]) <= (arr[right] - x)) {
                right--;
            } else {
            	left++;
            }
        }
        for (int i = left; i <= right; i++) {
            result.add(arr[i]);
        }
        return result;
        
        // less efficient solution
        /*
        Pair<Integer, Integer>[] pairs = new Pair[arr.length];
        for (int i = 0; i < arr.length; i++){
            pairs[i] = new Pair<Integer,Integer>(arr[i], Math.abs(arr[i] - x));
        }
        Arrays.sort(pairs, new MyComparator());
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < k; i++) {
            result.add(pairs[i].getKey());
        }
        Collections.sort(result);
        return result;
        */
    }

}
