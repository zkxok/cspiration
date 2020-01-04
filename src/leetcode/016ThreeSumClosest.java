package leetcode;

import java.util.Arrays;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : ThreeSumClosest
 * Creator : Edward
 * Date : Oct, 2017
 * Description : 16. 3Sum Closest
 */
public class ThreeSumClosest {
    /**
     * For example, given array S = {-1 2 1 -4}, and target = 1.

     The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

     time : O(n^2);
     space : O(1);

     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        //不能为Integer.MAX_VALUE,因为target可能为负,先随便选3个数作为三数之和
        int res = nums[0] + nums[1] + nums[nums.length - 1];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1, end = nums.length - 1;
            while (start < end) {//降到二维，至少还有两个数
                int sum = nums[i] + nums[start] + nums[end];
                if (sum > target) {
                    end--;
                } else start++;
                if (Math.abs(sum - target) < Math.abs(res - target)) {
                    res = sum;
                }
            }
        }
        return res;
    }
}
