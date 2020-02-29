  /*大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
    n<=39*/
    //第1题:Fibonacci数列
    //判题OJ:https://www.nowcoder.com/practice/c6c7742f5ba7442aada113136ddea0c3?tpId=13&tqId=11160&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
    public int Fibonacci(int n) {
        //first:前面2个，second:前面1个
        int first = 1, second = 1;
        int third = 0;
        if(n == 1 || n ==2) return 1;
        for(int i = 3; i <= n; i++){
            third = first + second;
            first = second;
            second = third;
        }
        return third;
    }
