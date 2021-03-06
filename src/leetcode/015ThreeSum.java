package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : ThreeSum
 * Creator : Edward
 * Date : Aug, 2017
 * Description : TODO
 */
public class ThreeSum {
    /**
     * 15. 3Sum
     * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
     * Find all unique triplets in the array which gives the sum of zero.

     Note: The solution set must not contain duplicate triplets.

     For example, given array S = [-1, 0, 1, 2, -1, -4],

     A solution set is:
     [
     [-1, 0, 1],
     [-1, -1, 2]
     ]

     time : O(n^2);
     space : O(n);
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {//至少有3个数参与,nums.length至少要等于3
            if (i > 0 && nums[i] == nums[i - 1]) continue;//去重0,降维的数也要去重
            int low = i + 1, high = nums.length - 1, sum = 0 - nums[i];//low是不断增加的，避免选到以前选过的数(重复选)
            while (low < high) {//降维成二维
                if (nums[low] + nums[high] == sum) {
                    res.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    while (low < high && nums[low] == nums[low + 1]) low++;//去重1
                    while (low < high && nums[high] == nums[high - 1]) high--;//去重2
                    low++;
                    high--;
                } else if (nums[low] + nums[high] < sum) {
                    low++;
                } else high--;
            }
        }
        return res;
    }
}
