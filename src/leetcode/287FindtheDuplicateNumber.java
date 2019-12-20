package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : FindtheDuplicateNumber
 * Creator : Edward
 * Date : Nov, 2017
 * Description : 287. Find the Duplicate Number
 */
public class FindtheDuplicateNumber {
    /**
     * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive),
     * prove that at least one duplicate number must exist. Assume that there is only one duplicate number,
     * find the duplicate one.

     1 2 3 4 5 6  7 8 8 9 10
     0 1 2 3 4 5  6 7 8 9 10  len = 11

     https://segmentfault.com/a/1190000003817671


     * @param nums
     * @return
     */

    // time : O(nlogn) space : O(1)
    public int findDuplicate(int[] nums) {
        int min = 0;
        int max = nums.length - 1;
        while (min <= max) {//至少一个数
            int mid = (max - min) / 2 + min;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) {//计算小于等于mid的个数
                    count++;
                }
            }
            if (count > mid) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }
    //题解:https://www.cnblogs.com/grandyang/p/4843654.html
    public int findDuplicate(int[] nums) {//n+1个数[1,n]
        int left = 1, right = nums.length;//n+1
        while (left < right){//至少两个数
            int mid = left + (right - left) / 2, cnt = 0;
            for (int num : nums) {
                if (num <= mid) ++cnt;
            }
            if (cnt <= mid) left = mid + 1;
            else right = mid;
        }    
        return right;//返回left也一样
    }

    // time : O(n) space : O(1)
    public int findDuplicate2(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
