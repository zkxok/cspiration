public class Numberof1Bits {
     使用n&(n-1)的方法：n&(n-1)作用：将n的二进制表示中的最低位为1的改为0
                n              n-1            n&(n-1)
     step1:   110101          110100          110100
     step2:   110100          110011          110000
     step3:   110000          101111          100000
     step4:   100000          011111          000000
     time : O(1) / O(n)
     space : O(1)
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res += n & 1;
            n >>= 1;
        }
        return res;
    }
    public int hammingWeight2(int n) {
        int res = 0;
        while (n != 0) {
            n &= (n - 1);
            res++;
        }
        return res;
    }
}
