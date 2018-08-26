package leetcode;

public class SearchInRotatedSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {4,5,6,7,0,1,2};
		int target = 3;
		search(nums, target);
	}
	
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) {
               if (nums[right] >= target){
                   left = mid + 1;
               } else {
                   if (nums[mid+1 + (right - mid - 1) / 2] >= target){
                       right = mid+1 + (right - mid - 1) / 2;
                   } else {
                       left = mid + 1;
                   }
               }
                
            }
            if (nums[mid] > target) {
                if (nums[left] > target){
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }                
            }
        }
        return -1;
    }

}
