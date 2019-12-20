package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : GameofLife
 * Creator : Edward
 * Date : Dec, 2017
 * Description : 289. Game of Life
 */
public class GameofLife {

    /**
     * Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

     Any live cell with fewer than two live neighbors dies, as if caused by under-population.
     Any live cell with two or three live neighbors lives on to the next generation.
     Any live cell with more than three live neighbors dies, as if by over-population..
     Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
     Write a function to compute the next state (after one update) of the board given its current state.

     time : O(m * n)
     space : O(1)

     * @param board
     */
    1. 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡
    2. 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活
    3. 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡
    4. 如果死细胞周围正好有三个活细胞，则该位置死细胞复活
     状态0： 死细胞转为死细胞
     状态1： 活细胞转为活细胞
     状态2： 活细胞转为死细胞
     状态3： 死细胞转为活细胞
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) return;
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = countNeighbor(board, i, j);
                if (board[i][j] == 1) {//自己是活细胞
                    if (count == 2 || count == 3) {
                        board[i][j] += 2;//活->活
                    }
                } else if (count == 3) {//自己是死细胞，且死细胞周围有3个1(活细胞)
                    board[i][j] += 2;//死->活
                }
                //转换成活细胞的只有状态1和3,其他的活->死,死->死，都不用管
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = board[i][j] >> 1;//相当于/(除以)2,加过2的/(除以)2,会变成1(只有状态1和3会+2);没加过2的0/1都会变成0
            }
        }
    }
    //计算(i,j)坐标周围1的个数(存活细胞的个数）
    private int countNeighbor(int[][] board, int i, int j) {
        int count = 0;
        for (int row = Math.max(0, i - 1); row <= Math.min(i + 1, board.length - 1); row++) {//避免越界
            for (int col = Math.max(0, j - 1); col <= Math.min(j + 1, board[0].length - 1); col++) {
                if (row == i && col == j) continue;//遍历到自己,不计入
                if ((board[row][col] & 1) == 1) count++;
            }
        }
        return count;
    }

}
