package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : JumpGame
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class JumpGame {
    /**
     * 55. Jump Game
     * For example:
     A = [2,3,1,1,4], return true.

     A = [3,2,1,0,4], return false.

     time : O(n)
     space : O(1)
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int max = 0;//当前能走到的最大(远)位置的索引
        for (int i = 0; i < nums.length; i++) {
            if (i > max) return false;//i>max说明它走不到i这个位置,i都倒不了，那肯定不能走到最后，直接范围false;
            //如果能到达坐标为i的点
            //每到达一个点后，要更新max的值,就是更新当前能走到的最远的位置坐标
            max = Math.max(nums[i] + i, max);//nums[i] + i是以当前这个点为起点能走到哪个位置
        }
        return true;
    }
}
