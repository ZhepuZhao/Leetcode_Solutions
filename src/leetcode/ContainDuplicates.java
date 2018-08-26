package leetcode;

import java.util.*;
import javafx.util.*;
public class ContainDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,0,1,1};
		int k = 1;
		containsNearbyDuplicate(nums, k);
	
	}

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length == 1 || nums.length == 0) return false;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++){
            if (map.containsKey(nums[i])){
                if (i - map.get(nums[i]) <= k) {
                    return true;
                } else{
                    map.replace(nums[i], i);
                }
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    
    }
}
