package leetcode;

/**
 * Created by Edward on 27/07/2017.
 */
public class Pow {
    /**
     * 50. Pow(x, n)
     * Implement pow(x, n).


     eg. 2^2 = 2^1 * 2^1 = (2^0 * 2^0 * 2) * (2^0 * 2^0 * 2) = (1 * 1 * 2) * (1 * 1 * 2) = 4

     eg. 2^3 = 2^1 * 2^1 * 2 = (2^0 * 2^0 * 2) * (2^0 * 2^0 * 2) * 2 = (1 * 1 * 2) * (1 * 1 * 2) * 2 = 8

     time : O(logn);
     space : O(n)/O(1)

     * @param x
     * @param n
     * @return
     */
    public double myPow1(double x, int n) {//递归版
        if (n > 0) {
            return pow(x, n);
        } else {
            return  1.0 / pow(x, n);
        }
    }
    public double pow (double x, int n) {
        if (n == 0) {
            return 1;
        }
        double y = pow(x, n / 2);
        if (n % 2 == 0) {
            return y * y;
        } else {
            return y * y * x;
        }
    }
    //time:O(logn),space:O(1)
    public static double myPow2(double x, int n) {
        if (n == 0) return 1;
        double res = 1;
        // int : -6.. ~ +6..  -2^32 ~ 2 ^32-1 Integer.MIN_VALUE
        long abs = Math.abs((long)n);
        while (abs > 0) {
            if (abs % 2 != 0) {
                res *= x;
            }
            x *= x;
            abs /= 2;
        }
        if (n < 0) {
            return 1.0 / res;
        }
        return res;
    }
    //time:O(logn),space:O(1),myPow2简化版
    public double myPow3(double x, int n) {
        double res = 1.0;
        //long abs = Math.abs((long)n);
        //long k = (long)n;不用强转long,因为这里没有把负数变成正数,不会越界
        for(int i = n; i != 0; i /= 2){//2//1
            if(i % 2 != 0){//奇数
                res *= x;//3*81=243.0
            }
            x *= x;//9//81
        }
        return  n < 0 ? 1 / res : res;
    }
}
