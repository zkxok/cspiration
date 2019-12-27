package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : LongestIncreasingSubsequence
 * Creator : Edward
 * Date : Sep, 2017
 * Description : 300. Longest Increasing Subsequence
 */
public class LongestIncreasingSubsequence {
    /**
     * Given an unsorted array of integers, find the length of longest increasing subsequence.

     For example,
     Given [10, 9, 2, 5, 3, 7, 101, 18],
     The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4.
     Note that there may be more than one LIS combination, it is only necessary for you to return the length.

     [10, 9, 2, 5, 3, 7, 101, 18]

     res == size

     10 res = 0 i = 0 j = 0
     9 res = 1 i = 0 j = 0 mid = 0
     2 res = 1 i = 0 j = 0 mid = 0
     5 res = 1 i = 1 j = 1 mid = 0
     3 res = 2
     7 res = 2 i = 2 j = 2 mid = 1
     101 res = 3 i = 2 j = 3 mid = 1
     18 res = 4 i = 3 j = 3 mid = 3


     i, j 相当于tails的起点，终点
     tails : [2,3,7,18]

     time : O(nlogn)
     space : O(n)

     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int res = 0;
        for (int num : nums) {
            int i = 0, j = res;
            while (i != j) {
                int mid = (i + j) / 2;
                if (tails[mid] < num) {
                    i = mid + 1;
                } else {
                    j = mid;
                }
            }
            tails[i] = num;
            if (i == res) res++;
        }
        return res;
    }
	
     //题解:https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-dong-tai-gui-hua-2/
     //动态规划
    //Time:O(N^2）,Space:O(n)
      public int lengthOfLIS2(int[] nums) {
		if (nums.length == 0) return 0;
		int[] dp = new int[nums.length];
		int res = 0;
		Arrays.fill(dp, 1);
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
			}
			res = Math.max(res, dp[i]);
		}
		return res;
	}
	
	
    public int lengthOfLIS3(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
        	//用二分查找法在 dp 数组找第一个不小于num的数字
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {//没找到
                i = -(i + 1);
            }
            dp[i] = num;//找到就覆盖它,如果这个数字不存在，那么直接在 dp 数组后面加上遍历到的数字
            if (i == len) {
                len++;
            }
        }
        return len;
    }
	*************最优的方法***********
        //动态规划+二分查找（Time: O(NlogN), Space:O(N)）
	//题解:https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-dong-tai-gui-hua-2/
	//https://www.cnblogs.com/grandyang/p/4938187.html
    public int lengthOfLIS4(int[] nums) {
        int[] tails = new int[nums.length];
        int res = 0;
        for(int num : nums) {
            int i = 0, j = res;//i相当于start,j相当于end,num相当于target
            //用二分查找法在 dp 数组找第一个不小于(大于等于)num的数字
            while(i < j) {//至少两个数
                int mid = (i + j) / 2;
                if(tails[mid] < num) i = mid + 1;
                else j = mid;
            }
	    //如果没有找到不小于(大于等于)num的数字,那么此时i值应该是tails的还没有元素的第一个空位,->反推数组元素个数
            tails[i] = num;//第一次,0位置就直接赋值了,这里tails[i]或者tails[j]都是一样的
	    //i+1是当前tails数组元素个数,res == i,说明当前res等于了数组长度-1,res要等于数组长度，那么需要res++或者写成res=i+1
            if(res == i) res++;//只有二分找到的这个i或者j,是dp数组的最后一个元素(也就是没找到大于等于num的元素,那么数组长度会增加),这里i或j都一样
        }
        return res;//最后返回 dp 数组的元素个数即可,
    }
}
