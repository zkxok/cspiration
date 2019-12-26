package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : JumpGameII
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class JumpGameII {
    /**
     * 45. Jump Game II
     * For example:
     Given array A = [2,3,1,1,4]

     The minimum number of jumps to reach the last index is 2. (Jump 1 res from index 0 to 1,
     then 3 ress to the last index.)

     * @param nums
     * @return
     */

    //time : O(n) space : O(1)
     //题解:https://www.cnblogs.com/grandyang/p/4373533.html
    public int jump(int[] nums) {
        if (nums == null || nums.length < 2) return 0;//只有一位不用跳
        int res = 0;
        int lastMax = 0;//在当前节点前(上一个位置),能到达的最远位置索引
        int curMax = 0;//从当前节点开始,能到达到的最远位置索引
        for (int i = 0; i < nums.length - 1; i++) {//只遍历nums.length - 1次
            curMax = Math.max(curMax, i + nums[i]);
            //i==lastMax之后再res++,到了i之后,还需要走一步,只遍历nums.length - 1次的原因:到了最后一个元素，就不需要继续再走了
            //因为它把第一个位置前也算做了一步，所以只能遍历nums.length - 1次
            if (i == lastMax) {//它刚刚好到达i位置,说明从i开始的这一步是必须的，不然就无法到达i位置，后面的就无法继续进行下去
                res++;//所以res++
                lastMax = curMax;//更新上一个位置能到达的最远位置索引
                //然后判断如果当前位置到达了 lastMax，即上一步能到达的最远位置，说明需要再跳一次了，
                //将 last 赋值为 cur，并且步数 res 自增1，这里小优化一下，判断如果 cur 到达末尾了，直接 break 掉即可
            }
        }
        return res;
    }

    /**
     [2,3,1,1,4]

     level = 2
     cur = 2
     max = 4
     i = 1

     * @param nums
     * @return
     */
    // time : O(n)  space : O(1)
    public int jump2(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        int level = 0;
        int curMaxArea = 0;
        int maxNext = 0;
        int i = 0;
        while (curMaxArea - i + 1 > 0) {
            level++;
            for (; i <= curMaxArea; i++) {
                maxNext = Math.max(maxNext, nums[i] + i);
                if (maxNext >= nums.length - 1) {
                    return level;
                }
            }
            curMaxArea = maxNext;
        }
        return 0;
    }
}
