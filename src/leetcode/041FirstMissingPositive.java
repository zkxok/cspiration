package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : FirstMissingPositive
 * Creator : Edward
 * Date : Nov, 2017
 * Description : 41. First Missing Positive
 */
public class FirstMissingPositive {
    /**
     * Given an unsorted integer array, find the first missing positive integer.

     For example,
     Given [1,2,0] return 3,
     and [3,4,-1,1] return 2.

     Your algorithm should run in O(n) time and uses constant space.

     time : O(n)
     space : O(1)

     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 1;
        for (int i = 0; i < nums.length; i++) {
            //不是排序,小于等于0的数不能参与排序
            //如果正常nums[nums[i] - 1]应该等于nums[i],当前nums[i]的值本应该在索引为(nums[i] - 1)的位置,如果不在，那就将它交换到那个位置
            //这里是while,不是if,还有nums[nums[i] - 1] != nums[i]不能写成nums[i] - 1!=i,如果这样写输入[1,1],nums[i] - 1!=i,这个条件将永远满足
            //会陷入死循环
            while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}
