package leetcode;

import java.util.*;
public class FindAllDuplicatesInAnArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {4,3,2,7,8,2,3,1};
		List<Integer> list = findDuplicates(nums);
	}

	public static List<Integer> findDuplicates(int[] nums) {

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i])-1; // index should be the position the nums[i] locates
            if (nums[index] < 0)
                res.add(Math.abs(index+1));
            nums[index] = -nums[index]; // set to negative means the position has the value which is position + 1
            // for example, in the current case, -3 means there is a 2 which has been iterated. So if there is another 2
            // and it should see that the position 1 is a negative number. then 2 is the duplicate number
        }
        return res;
	}

	public static void swap(int[] nums, int a, int b) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}

}
