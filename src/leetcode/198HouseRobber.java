package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : HouseRobber
 * Creator : Edward
 * Date : Oct, 2017
 * Description : 198. House Robber
 */
public class HouseRobber {
    /**
     * You are a professional robber planning to rob houses along a street.
     * Each house has a certain amount of money stashed, the only constraint stopping you from robbing
     * each of them is that adjacent houses have security system connected and it will automatically contact
     * the police if two adjacent houses were broken into on the same night.
     *
     [1, 3, 2, 4, 1]
          No  Yes
     1 :  0    1
     3 :  1    3
     2 :  3    3

     time : O(n)
     space : O(1)

     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int prevNo = 0;//代表之前的房子没偷
        int prevYes = 0;
        for (int num : nums) {
            int temp = prevNo;//代表之前的房子没偷,取temp的原因是preNo会改变
            prevNo = Math.max(prevNo, prevYes);
            prevYes = num + temp;//当前值+代表之前的房子没偷的值
        }
        return Math.max(prevNo, prevYes);
    }
    
    ******
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0],nums[1]);
        int dp[] = new int[nums.length];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<nums.length;i++){
            dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return dp[nums.length-1];
    }
}
