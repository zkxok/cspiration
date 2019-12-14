package leetcode;

import java.util.HashMap;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : ContainsDuplicateII
 * Creator : Edward
 * Date : Oct, 2017
 * Description : 219. Contains Duplicate II
 */
public class ContainsDuplicateII {
    //time : O(n) space : O(n)
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                //只有存在nums [i] = nums [j],并且 i 和 j 的差的绝对值最大为 k,就满足
                if ((i - map.get(nums[i])) <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }
}
