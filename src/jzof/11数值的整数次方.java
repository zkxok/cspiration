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
