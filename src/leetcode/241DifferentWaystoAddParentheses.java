package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : DifferentWaystoAddParentheses
 * Creator : Edward
 * Date : Nov, 2017
 * Description : 241. Different Ways to Add Parentheses
 */
public class DifferentWaystoAddParentheses {
    /**
     * Given a string of numbers and operators, return all possible results from computing
     * all the different possible ways to group numbers and operators. The valid operators are +, - and *.


     Example 1
     Input: "2-1-1".

     ((2-1)-1) = 0
     (2-(1-1)) = 2
     Output: [0, 2]


     Example 2
     Input: "2*3-4*5"

     (2*(3-(4*5))) = -34
     ((2*3)-(4*5)) = -14
     ((2*(3-4))*5) = -10
     (2*((3-4)*5)) = -10
     (((2*3)-4)*5) = 10
     Output: [-34, -14, -10, -10, 10]

     time : O(n^3) 不确定
     space : O(n)


     * @param input
     * @return
     */
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '-' || c == '+' || c == '*') {
                String a = input.substring(0, i);
                String b = input.substring(i + 1);
                List<Integer> al = diffWaysToCompute(a);
                List<Integer> bl = diffWaysToCompute(b);
                for (int x : al) {
                    for (int y : bl) {
                        if (c == '-') {
                            res.add(x - y);
                        } else if (c == '+') {
                            res.add(x + y);
                        } else if (c == '*') {
                            res.add(x * y);
                        }
                    }
                }
            }
        }
        if (res.size() == 0) {
            res.add(Integer.valueOf(input));
        }
        return res;
    }
    
    
    ********上文加注释****************
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '-' || c == '+' || c == '*') {
                String a = input.substring(0, i);//这里的截取就是相当于括号的作用了,将数字划分为两个部分
                String b = input.substring(i + 1);
                List<Integer> al = diffWaysToCompute(a);//数字a的集合,为什么是集合?因为数字a还可能继续划分多种情况,产生多种可能
                List<Integer> bl = diffWaysToCompute(b);//数字b的集合
                for (int x : al) {
                    for (int y : bl) {
                        if (c == '-') {
                            res.add(x - y);
                        } else if (c == '+') {
                            res.add(x + y);
                        } else if (c == '*') {
                            res.add(x * y);
                        }
                    }
                }
            }
        }
        if (res.size() == 0) {//没有运算符，只有数字,递归的时候，会递归到只有一个数字,res为空,需要把数字加进集合
            res.add(Integer.valueOf(input));
        }
        return res;
    }
}
