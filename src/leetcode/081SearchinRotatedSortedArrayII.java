package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : SearchinRotatedSortedArrayII
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class SearchinRotatedSortedArrayII {

    /**
     * 81. Search in Rotated Sorted Array II
     * Follow up for "Search in Rotated Sorted Array":
     What if duplicates are allowed?

     1 1 1 3 1

     time : O(logn) (worst : O(n))
     space : O(1);
     * @param nums
     * @param target
     * @return
     */

    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] == target) return true;
            if (nums[start] == nums[mid] && nums[mid] == nums[end]) {
                start++;
                end--;
            } else if (nums[start] <= nums[mid]) {
                if (nums[start] <= target && target <= nums[mid]) end = mid;
                else start = mid;
            } else {
                if (nums[mid] <= target && target <= nums[end]) start = mid;
                else end = mid;
            }
        }
        if (nums[start] == target) return true;
        if (nums[end] == target) return true;
        return false;
    }
    
    
    public boolean search(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return false;
		int start = 0;
		int end = nums.length - 1;
		while (start + 1 < end) {
			int mid = (end - start) / 2 + start;
			if (nums[mid] == target) {
				return true;
			}else if(nums[start] == nums[mid]&&//&& nums[mid] == nums[end]){//加上注释掉的两部分也行
				start++;
				//end--;
			}else if (nums[start] <=nums[mid]) {// start->mid 递增，这里必须有=,否则可能陷入死循环
				if (nums[start] <= target && target <= nums[mid]) {
					end = mid - 1;
				} else {
					start = mid;
				}
			} else if (nums[mid] <= nums[end]) {// mid ->end 递增
            //这里必须有=,或者直接else
				if (nums[mid] <= target && target <= nums[end]) {
					start = mid + 1;
				} else {
					end = mid;
				}
			}
		}
		if (nums[start] == target) return true;
		if (nums[end] == target) return true;
		return false;
	}
}
