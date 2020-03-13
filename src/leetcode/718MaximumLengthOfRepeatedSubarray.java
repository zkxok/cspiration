import java.util.*;

public class Solution {
    public static String lcs(String s1, String s2) {
        if (s1 == null || s2 == null || s1.equals("") || s2.equals(""))
            return "";
        char c1[] = s1.toCharArray();
        char c2[] = s2.toCharArray();
        int row = 0;// 斜线开始位子的行
        int col = c2.length - 1;
        int maxLen = 0;// 记录最大长度
        int end = 0;// 最大长度更新时，记录子串的结尾位置
        while (row < c1.length) {
            int i = row;
            int j = col;
            int len = 0;
            while (i < c1.length && j < c2.length) {
                if (c1[i] != c2[j]) len = 0;
                else len++;
                if (len > maxLen) {
                    end = i;
                    maxLen = len;
                }
                i++;
                j++;
            }
            if (col > 0) col--;// 斜线开始位置的列先向左移动
            else row++;// 列移动到最左之后，行向下移动
        }
        return s1.substring(end - maxLen + 1, end + 1);
    }
    
    
    /*public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s1 = in.nextLine();
            String s2 = in.nextLine();
            String res = lcs(s1, s2);
            System.out.println(res.length() > 0 ? res : -1);
        }
        in.close();
    }*/

}
