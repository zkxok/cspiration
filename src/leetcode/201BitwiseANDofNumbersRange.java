package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : BitwiseANDofNumbersRange
 * Creator : Edward
 * Date : Dec, 2017
 * Description : 201. Bitwise AND of Numbers Range
 */
public class BitwiseANDofNumbersRange {

    /**
     * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

     For example, given the range [5, 7], you should return 4.

     time : < O(n) ~ O(1)
     space : O(1)


     * @param m
     * @param n
     * @return
     */

    public int rangeBitwiseAnd(int m, int n) {
        int offset=0;
        //只要出现奇偶数,对应位置一定是0,因为是连续的，所以一定会有奇偶数,唯一可能为1的一位就是首位
        while(m!=n){
            m>>=1;
            n>>=1;
            offset++;
        }
        return m<<offset;//或者m<<offset
    }
}
