package leetcode;

import java.util.*;

public class Subsets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 2, 3 };
		subsets(nums);
		int temp = 0;
	}

	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> subset = new ArrayList<List<Integer>>();
		if (nums.length == 0 || nums == null)
			return subset;
		helper(subset, new ArrayList<Integer>(), nums, 0);
		return subset;
	}

	public static void helper(List<List<Integer>> subset, List<Integer> list, int[] nums, int index){
//	        List<Integer> temp = new ArrayList<Integer>();
//	        temp.addAll(list);
//			subset.add(temp);
			// the next line can replace the 3 lines above
			subset.add(new ArrayList<Integer>(list));
	        
	        for (int i = index; i < nums.length; i++){
	            list.add(nums[i]);
	            helper(subset, list, nums, i + 1);
	            list.remove(list.size()-1);
	        }
	    }

}
