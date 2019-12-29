package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : SingleNumberIII
 * Creator : Edward
 * Date : Dec, 2017
 * Description : 260. Single Number III
 */
public class SingleNumberIII {
    /**
     * Given an array of numbers nums, in which exactly two elements appear only once and
     * all the other elements appear exactly twice. Find the two elements that appear only once.

     For example:

     Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

     A B : 二进制数字有且至少有一位是不相同

     3 : 011
     5 : 101

     3 ^ 5 : 110  -- 6
     -6 : 11111111111111111111111111111010
     6 & -6 : 000010

     1, 2, 1, 3, 2, 5

     diff = 3 ^ 5

     time : O(n)
     space : O(1)


     * @param nums
     * @return
     */
       //分组法
    public int[] singleNumber2(int[] nums) {
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        //我们用 diff &= -diff 来取出最右端为 ‘1’ 的位
        diff &= -diff;//这一步最难理解,diff是两个不同的数异或来的结果,diff某位为１，说明在这位上，这个两个数不同（分别为0和1，根据这个就可以将这个两个元素分开到两个组里
        //最后得出来的diff的结果，是这两个数出现不同是从哪位开始的(从低位到高位)
        //如果两个相同的数字 '异或' ，每位都会是0，而不同的数字 '异或' ，一定会有对应位不同，一个0一个1，这样 '异或' 是1。比如3和5的二进制 11 和 101，如果从低往高看，最开始产生不同的就是第二位，那么我们用第二位来和数组中每个数字相与，根据结果的不同，一定可以把3和5区分开来，而其他的数字由于是成对出现，所以区分开来也是成对的，最终都会 '异或' 成0，不会3和5产生影响。
        int[] res = new int[2];
        for (int num : nums) {
            if ((num & diff) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }
        return res;
    }


    public int[] singleNumber(int[] nums) {
        int diff = 0;
        int [] res = new int[2];
        for (int num : nums) diff ^= num;
        
        diff &= -diff;//-diff先取补码，再加一，此句找出最右侧的1
        
        for (int num : nums){
            if ((num & diff) == 0) res[0] ^= num;
            else res[1] ^= num;
        }
        return res;
    }
}
