package leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by Edward on 23/07/2017.
 */
public class TwoSum {

    /**
     *  1. Two Sum

     Given an array of integers, return indices of the two numbers such that they add up to a specific target.

     You may assume that each input would have exactly one solution, and you may not use the same element twice.

     Given nums = [2, 7, 11, 15], target = 9,

     Because nums[0] + nums[1] = 2 + 7 = 9,

     return [0, 1].

     time : O(n)
     space : O(n)
     * @param nums
     * @param target
     * @return
     */

    public static int[] twoSum(int[] nums, int target) {
       if (nums == null || nums.length < 2) {
           return new int[]{-1, -1};
       }
       int[] res = new int[]{-1, -1};
       HashMap<Integer, Integer> map = new HashMap<>();
       for (int i = 0; i < nums.length; i++) {
           if (map.containsKey(target - nums[i])) {
               res[0] = map.get(target - nums[i]);
               res[1] = i;
               break;
           }
           map.put(nums[i], i);
       }
       return res;
    }

    //上面解法的注释版:最优解法
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        //int res[] = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                //为啥不用判断map.get(target - nums[i])和i是否相等?
                //因为他们不可能会相等,如果map中已经存在target - nums[i]这个元素
                //那么因为是顺序遍历，那么它的索引肯定是小于i的
                //和两边hash的不一样
                //你当前遍历到的这个i索引的元素(索引和元素都相等的元素))肯定是没在map里的
                //res[0] = i;
                //res[1] = map.get(target - nums[i]);
                // return res;
                return new int[] { i, map.get(target - nums[i]) };
            }
            map.put(nums[i], i);
        }
        return new int[] { -1, -1 };
    }
}
