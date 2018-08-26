package leetcode;

import java.util.*;

public class IntersectionOfTwoArrays2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = { 1, 2, 2, 1 };
		int[] nums2 = { 2, 2 };
		intersect(nums1, nums2);
	}

	public static int[] intersect(int[] nums1, int[] nums2) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i : nums1) {
			if (map.containsKey(i)) {
				map.replace(i, map.get(i) + 1);
			} else {
				map.put(i, 1);
			}
		}
		List<Integer> list = new ArrayList<Integer>();
		for (int i : nums2) {
			if (map.containsKey(i) && map.get(i) != 0) {
				map.replace(i, map.get(i) - 1);
				list.add(i);
			}
		}
		int[] result = new int[list.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = list.get(i);
		}
		return result;
	}

}
