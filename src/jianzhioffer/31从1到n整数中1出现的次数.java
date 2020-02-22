class Solution {
    public int countDigitOne(int n) {
        int res = 0;
        for (long m = 1; m <= n; m *= 10) {
            long a = n / m;//百位的数字,有多少个100
            long b = n % m;//余数
            res += (a + 8) / 10 * m;//(a + 8) / 10 判断是m位(这里是百位)否是1,如果百位数字a为>=2,(3141+1) *100 次.
            if (a % 10 == 1) res += b + 1;//如果百位是1,(92+1) 次.
        }
        return res;
    }
}
