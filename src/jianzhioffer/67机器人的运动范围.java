public class Solution {
    /**
     * 用回溯法实现，从起点出发，从每个点的左右上下开始寻找，如果任何一个方向
     已经寻找过或者超出边界或者不满足条件，则停止这个方向的寻找，从另外一个
     方向开始寻找每次满足条件，则满足条件个数+1，这样一直找，直到没有满足条
     件的点
     * @param threshold 临界值
     * @param rows 行
     * @param cols 列
     * @return 能够到达的格子
     */
    public int movingCount(int threshold, int rows, int cols) {
        int flag[][] = new int[rows][cols]; // 记录是否已经走过(1:走过，0:没走过)
        return movingCountCore(0, 0, rows, cols, flag, threshold);
    }

    private int movingCountCore(int i, int j, int rows, int cols, int[][] flag, int threshold) {
        if (i < 0 || i >= rows
                || j < 0 || j >= cols
                || getDigitSum(i) + getDigitSum(j) > threshold
                || flag[i][j] == 1)//越界或已走过或不满足条件,停止这个方向的寻找,直接返回0
            return 0;

        flag[i][j] = 1;
        return movingCountCore(i - 1, j, rows, cols, flag, threshold)//左
                + movingCountCore(i + 1, j, rows, cols, flag, threshold)//右
                + movingCountCore(i, j - 1, rows, cols, flag, threshold)//上
                + movingCountCore(i, j + 1, rows, cols, flag, threshold)//下
                + 1;
    }

    //求一个数的数位和
    int getDigitSum(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

}
