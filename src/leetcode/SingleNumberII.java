package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : SingleNumberII
 * Creator : Edward
 * Date : Nov, 2017
 * Description : 137. Single Number II
 */
public class SingleNumberII {
    /**
     * Given an array of integers, every element appears three times except for one, which appears exactly once.
     * Find that single one

     0 -> 1 -> 2 -> 0
     00 -> 01 -> 10 -> 00
     00 -> 10 -> 01 -> 00

     ones twos
      0     0
     0 -> 1 0 -> 0
     1 -> 0 0 -> 1
     0 -> 0 1 -> 0

     1, 存入ones里
     2，清空ones 存入twos
     3，twos进行清空

     time : O(n)
     space : O(1)

//https://zhangluncong.com/2018/09/15/singleNumber/
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for (int i = 0; i < nums.length; i++) {
            ones = (ones ^ nums[i]) & ~twos;
            twos = (twos ^ nums[i]) & ~ones;
        }
        return ones;
    }
    
    
    
    
    public int singleNumber(int[] nums) {
        int a = 0, b = 0;
        for (int num : nums){
            a = (a ^ num) & ~b;
            b = (b ^ num) & ~a;
        }
        return a;
    }
    
    
    
    
    ******************************
        
        
        解法三 位操作
136 题通过异或解决了问题，这道题明显不能用异或了，参考 这里 的一个解法。

我们把数字放眼到二进制形式

假如例子是 1 2 6 1 1 2 2 3 3 3, 3 个 1, 3 个 2, 3 个 3,1 个 6
1 0 0 1
2 0 1 0 
6 1 1 0 
1 0 0 1
1 0 0 1
2 0 1 0
2 0 1 0
3 0 1 1  
3 0 1 1
3 0 1 1      
看最右边的一列 1001100111 有 6 个 1
再往前看一列 0110011111 有 7 个 1
再往前看一列 0010000 有 1 个 1
我们只需要把是 3 的倍数的对应列写 0，不是 3 的倍数的对应列写 1    
也就是 1 1 0,也就是 6。
原因的话，其实很容易想明白。如果所有数字都出现了 3 次，那么每一列的 1 的个数就一定是 3 的倍数。之所以有的列不是 3 的倍数，就是因为只出现了 1 次的数贡献出了 1。所以所有不是 3 的倍数的列写 1，其他列写 0 ，就找到了这个出现 1 次的数。

public int singleNumber(int[] nums) {
    int ans = 0;
    //考虑每一位
    for (int i = 0; i < 32; i++) {
        int count = 0;
        //考虑每一个数的第i位
        for (int j = 0; j < nums.length; j++) {
            //当前位是否是 1
            if ((nums[j] >>> i & 1) == 1) {
                count++;
            }
        }
        //1 的个数是否是 3 的倍数
        if (count % 3 != 0) {
            ans = ans | 1 << i;//或，有１为1，无１为0
        }
    }
    return ans;
}

时间复杂度：O（n）。

空间复杂度：O（1）。


}
