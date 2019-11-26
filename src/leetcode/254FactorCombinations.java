package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : FactorCombinations
 * Creator : Edward
 * Date : Aug, 2017
 * Description : TODO
 */
public class FactorCombinations {

    /**
     * 254. Factor Combinations
     * Numbers can be regarded as product of its factors. For example,

     8 = 2 x 2 x 2;
     = 2 x 4.
     Write a function that takes an integer n and return all possible combinations of its factors.

     Note:
     You may assume that n is always positive.
     Factors should be greater than 1 and less than n.
     Examples:
     input: 1
     output:
     []
     input: 37
     output:
     []
     input: 12
     output:
     [
     [2, 6],
     [2, 2, 3],
     [3, 4]
     ]
     input: 32
     output:
     [
     [2, 16],
     [2, 2, 8],
     [2, 2, 2, 4],
     [2, 2, 2, 2, 2],
     [2, 4, 4],
     [4, 8]
     ]

     * @param n
     * @return
     */

    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), n, 2);
        return res;
    }
    public void helper(List<List<Integer>> res, List<Integer> list, int n, int start) {
        if (n == 1) {
            if (list.size() > 1) {
                res.add(new ArrayList<>(list));
                return;
            }
        }
        for (int i = start; i <= n; i++) {
            if (n % i == 0) {
                list.add(i);
                helper(res, list, n / i, i);
                list.remove(list.size() - 1);
            }
        }
    }
    
    **************
        
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res =new ArrayList<>();
        helper(res,n,new ArrayList<>(),2);
        return res;
    }

    public void helper(List<List<Integer>> res,int n,List<Integer> tempList,int start){
        if(n==1){//都分解完
            if(tempList.size()>1){
                res.add(new ArrayList<>(tempList));
            }
            return;
        }
        //这里回不需要去重复,如n=12=3*4=4*3;如果设置i=2,那么就会出现重复，但顺序不一样的解;但是这里i=start，后续start递增，所以后面不会出现比前面小的因数
        for(int i=start;i<=n;i++){//一定要到n,比如12=2*6;第２轮,n=6,不到n,6就无法区到
            if(n%i!=0)continue;
            tempList.add(i);
            helper(res,n/i,tempList,i);//6
            tempList.remove(tempList.size()-1);
        }
    }
}
