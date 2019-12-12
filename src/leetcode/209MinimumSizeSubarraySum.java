package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : MinimumSizeSubarraySum
 * Creator : Edward
 * Date : Nov, 2017
 * Description : 209. Minimum Size Subarray Sum
 */
public class MinimumSizeSubarraySum {
    /**
     * Given an array of n positive integers and a positive integer s, find the
     * minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

     For example, given the array [2,3,1,2,4,3] and s = 7,
     the subarray [4,3] has the minimal length under the problem constraint.

     time : O(n)
     space : O(1)

     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {
        int res = Integer.MAX_VALUE;
        int left = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {//以left开头,i为结尾
            sum += nums[i];
            while (left <= i && sum >= s) {
                res = Math.min(res, i -left + 1);
                sum -= nums[left++];//既然满足了sum>s的要求，那么left右移减少一位子啊看看，
                //还是否能满足要求,因为要求满足条件的最小长度
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
