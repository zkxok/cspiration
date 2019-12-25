package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : SearchinRotatedSortedArray
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class SearchinRotatedSortedArray {

    /**
     * 33. Search in Rotated Sorted Array
     * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

     (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

     You are given a target value to search. If found in the array return its index, otherwise return -1.

     You may assume no duplicate exists in the array.

     4 5 6 7 0 1 2

     4 5 6 0 1 2 3

     time : O(logn);
     space : O(1);
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] == target) return mid;
            if (nums[start] < nums[mid]) {
                if (nums[start] <= target && target <= nums[mid]) {
                    end = mid;
                } else start = mid;
            } else {
                if (nums[mid] <= target && target <= nums[end]) {
                    start = mid;
                } else end = mid;
            }
        }
        if (nums[start] == target) return start;
        if (nums[end] == target) return end;
        return -1;
    }
    
    
    public int search2(int[] nums, int target) {
		if (nums == null || nums.length == 0) return -1;
		int start = 0;
		int end = nums.length - 1;
	        //不能有=,否则只有两个元素的时候，会死循环,下面3个if判断永远都不会满足
		while (start + 1 < end) {//至少3个数参与,如果1个数或者2个数，不用这么麻烦
			int mid = (end - start) / 2 + start;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[start] < nums[mid]) {// start->mid 升序
				if (nums[start] <= target && target <= nums[mid]) end = mid;
				else start = mid + 1;
			} else if (nums[mid] < nums[end]) {// mid->end升序
				if (nums[mid] <= target && target <= nums[end]) start = mid;
				else end = mid - 1;
			}
		}
		//能够走到这里说明只有1个数或者2个数
		if (nums[start] == target) return start;
		if (nums[end] == target) return end;
		return -1;
	}
}
