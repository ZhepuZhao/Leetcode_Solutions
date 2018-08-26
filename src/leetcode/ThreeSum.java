package leetcode;

import java.util.*;
public class ThreeSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-4,0,-2,1,-5,-4,-4,4,-2,4,0,-2,3,1,-5,0};
		threeSum(nums);
	}
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Set<Integer> set = new HashSet<Integer>();
        
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) continue;
            set.add(nums[i]);
            
            int start = 1, end = nums.length - 1;
            int[] clone = nums.clone();
            swap(clone, i, 0);
            Arrays.sort(clone, 1, nums.length);
            
            while (start < end) {
                if (clone[start] + clone[end] == 0 - clone[0]) {
                    result.add(new ArrayList<Integer>());
                    result.get(result.size()-1).add(clone[0]);
                    result.get(result.size()-1).add(clone[start]);
                    result.get(result.size()-1).add(clone[end]);
                    start++;
                    end--;
                } else if (clone[start] + clone[end] < 0 - clone[0]){
                    start++;
                } else {
                    end--;
                }
            }
        }
        for (int i = 0; i < result.size(); i++) {
            for (int j = i + 1; j < result.size(); j++) {
                if (result.get(i).containsAll(result.get(j)) && result.get(j).containsAll(result.get(i))) {
                    result.remove(j);
                    j--;
                }
            }
        }
        return result;
    }
    private static void swap (int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
