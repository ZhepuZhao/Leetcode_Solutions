package leetcode;

public class MajorityElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3,2,3};
		majorityElement(nums);
	}

	public static int majorityElement(int[] nums) {
		int count = 0;
		Integer candidate = null;

		for (int num : nums) {
			if (count == 0) {
				candidate = num;
			}
			count += (num == candidate) ? 1 : -1;
		}

		return candidate;
	}

}
