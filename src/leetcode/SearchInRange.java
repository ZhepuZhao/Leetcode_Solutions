package leetcode;

public class SearchInRange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int[] nums = {1,2,2};
		int[] nums = {1,1,2};
		int target = 1;
		System.out.println(searchRange(nums,target)[0] + " " + searchRange(nums,target)[1]);
	}
    public static int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int start = Integer.MAX_VALUE;
        int end = 0;
        if (nums.length == 0) return new int[]{-1,-1};
        while (left + 1 < right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                if (mid < start){
                    start = mid;
                }
                if (mid > end) {
                    end = mid;
                }
                if (nums[mid] < nums[mid+1]){
                    right = mid;
                } else {
                    left = mid;
                }
            }
            if (nums[mid] > target){
                right = mid;
            } else {
                left = mid;
            }
        }
        
        int[] result = {-1,-1};
        if (nums.length ==1){
            if (nums[0] == target){
                return new int[]{0,0};
            } else {
                return new int[]{-1,-1};
            }
        }
        // length of 2
        if (nums.length == 2){
            if (nums[left] == target && nums[right] == target){
                result[0] = left; 
                result[1] = right;
            }
            if (nums[left] == target && nums[right] != target){
                result[0] = left;
                result[1] = left;
            }
            if (nums[left] != target && nums[right] == target){
                result[0] = right;
                result[1] = right;
            }                  
        }
      
        if (start != Integer.MAX_VALUE){
            if (start > left){
                if (nums[left] == target){
                    result[0] = left;
                    result[1] = end;
                } else {
                    result[0] = start;
                    result[1] = end;
                }
            } else {
                if (nums[right] == target){
                    result[0] = start;
                    result[1] = end +1;
                } else {
                    result[0] = start;
                    result[1] = end;                    
                }
            }
        }
        return result;
        
    }

}
