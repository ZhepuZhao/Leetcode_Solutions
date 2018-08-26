package leetcode;
import java.util.*;
public class SingleNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2,2,1,4,4,5,7,7,8,8,5};
		singleNumber(nums);
		Set<Integer> hashSet = new HashSet<Integer>();
		hashSet.add(0);
		hashSet.add(1);

	}
    public static int singleNumber(int[] nums) {
        Set<Integer> hashSet = new HashSet<Integer>();
        for (int i : nums){
            if (!hashSet.remove(i)){
                hashSet.add(i);
            }
        }
        return (int) hashSet.iterator().next();
    }

}
