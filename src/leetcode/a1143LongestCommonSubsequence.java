import java.util.*;
public class Main{
    public int lcsLen(String s1, String s2) {//求公共子序列的长度
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
    
    //time:O(m*n),space:O(m*n)
    //time(不算构建dp数组):O(1),space:O(m*n)
    public static String lcs(String s1, String s2) {//求公共子序列
        if (s1 == null || s2 == null || s1.equals("") || s2.equals(""))
            return "";
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int[][] dp = getdp(c1, c2);
        int m = c1.length - 1, n = c2.length - 1;
        char res[] = new char[dp[m][n]];
        int index = res.length - 1;
        while (index >= 0) {
            if (n > 0 && dp[m][n] == dp[m][n - 1]) {
                n--;
            } else if (m > 0 && dp[m][n] == dp[m - 1][n]) {
                m--;
            } else {
                res[index--] = c1[m];//从表格尾部开始加(从尾到头找)
                m--;
                n--;
            }
        }
        return String.valueOf(res);
    }

    //time:O(m*n),space:O(m*n)
    public static int[][] getdp(char[] c1, char[] c2) {
        int n1 = c1.length, n2 = c2.length;
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (c1[i - 1] == c2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp;
    }
    
    
    
    //牛客OJ:https://www.nowcoder.com/questionTerminal/4727c06b9ee9446cab2e859b4bb86bb8
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        System.out.println(lcs(str1, str2));
    }*/
}
