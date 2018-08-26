package leetcode;

import java.util.Stack;

public class RemoveDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {0,0,1,1,2,2,3};
		removeDuplicates(a);
		int b = 0;
		char my= '0';
		Character.getNumericValue(my);
		System.out.println(b+my);
		
	}
	
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int p = 0;
        int max = nums[0];
        for (int i = 0; i < nums.length; i++){
            if (max > nums[i]){
                p++;
            }
            if (max < nums[i]){
            	max = nums[i];
                int temp = nums[p+1];
                nums[p+1] = nums[i];
                nums[i] = temp;
                p++;                
            }
        }
        return p+1;
    }

}
