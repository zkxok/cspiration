import java.util.*;
public class Solution {
    public int LastRemaining_Solution(int n, int m) {
        if(n<1||m<1) return -1;
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int i=0;i<n;i++){
            res.add(i);
        }
        int index = -1;
        while(res.size()>1){
            index = (index+m)%res.size();
            res.remove(index);
            index --;
        }
        return res.get(0);
    }
}

public class Solution {
    public int LastRemaining_Solution(int n, int m) {
        if(n<1 || m<1){
            return -1;
        }
        int last = 0;
        for(int i=2;i<=n;i++){
            last = (last+m)%i;
        }
        return last;
    }
}
