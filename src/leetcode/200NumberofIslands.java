package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : NumberofIslands
 * Creator : Edward
 * Date : Nov, 2017
 * Description : 200. Number of Islands
 */
public class NumberofIslands {

    /**
     * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
     * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
     * You may assume all four edges of the grid are all surrounded by water.

     Example 1:

     11110
     11010
     11000
     00000
     Answer: 1

     Example 2:

     11000
     11000
     00100
     00011
     Answer: 3

     time : O(m * n)
     space : O(n)

     * @param grid
     * @return
     */

    private int m;
    private int n;

    public int numIslands(char[][] grid) {
        int res = 0;
        m = grid.length;
        if (m == 0) return 0;
        n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    //深度优先遍历，把和这个'1'挨着的都变成0,把属于这个岛的'1'都变成了0,表示这个岛已经算过了
                    dfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    /**
     time : O(m * n)
     space : O(m * n)
     * @param grid
     * @param i
     * @param j
     */

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == '0') return;
        grid[i][j] = '0';
        //上下左右
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
    }

    public int numIslands2(char[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private void bfs(char[][] grid, int x, int y) {
        grid[x][y] = '0';
        int n = grid.length;
        int m = grid[0].length;
        Queue<Integer> queue = new LinkedList<>();
        int code = x * m + y;
        queue.offer(code);
        while (!queue.isEmpty()) {
            code = queue.poll();
            int i = code / m;
            int j = code % m;
            if (i > 0 && grid[i - 1][j] == '1') {
                queue.offer((i - 1) * m + j);
                grid[i - 1][j] = '0';
            }
            if (i < n - 1 && grid[i + 1][j] == '1') {
                queue.offer((i + 1) * m + j);
                grid[i + 1][j] = '0';
            }
            if (j > 0 && grid[i][j - 1] == '1') {
                queue.offer((i * m) + j - 1);
                grid[i][j - 1] = '0';
            }
            if (j < m - 1 && grid[i][j + 1] == '1') {
                queue.offer((i * m) + j + 1);
                grid[i][j + 1] = '0';
            }
        }
    }
}




class Solution {
    int m ,n;
    public int numIslands(char[][] grid) {
        m = grid.length;
        if(m<=0) return 0;
        n = grid[0].length;
        int res=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    bfs(grid,i,j);
                    res++;
                } 
            }
        }
        return res;
    }

    public void bfs(char[][] grid,int x,int y){
        //grid[x][y] = '0';//此节点自身也是1，也需要置'0'，
        //但是实际上不置'0',也不影响最后结果,因为它上下左右都置'0'了,和下一个岛的'1',
        //是不可能相邻,所以不会再次遍历遍历这里,相当于每个岛只保存了第一次遍历到的那个'1';
        // int n = grid.length;
        // int m = grid[0].length;
        Queue<Integer> queue = new LinkedList<Integer>();
        int code = x*n+y;
        queue.offer(code);//遍历当前这个节点挨着的'1';
        while(!queue.isEmpty()){
            code = queue.poll();
            int i = code/n;
            int j = code%n;
            if(i>0&&grid[i-1][j]=='1') {
                queue.offer((i-1)*n+j);
                grid[i-1][j]='0';
            }
            if(i<m-1&&grid[i+1][j]=='1') {
                queue.offer((i+1)*n+j);
                grid[i+1][j]='0';
            }
            if(j>0&&grid[i][j-1]=='1'){
                queue.offer(i*n+j-1);
                grid[i][j-1]='0';
            }
            if(j<n-1&&grid[i][j+1]=='1'){
                queue.offer(i*n+j+1);
                grid[i][j+1]='0';
            }
        }
    }
}
