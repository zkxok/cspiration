package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : MergeIntervals
 * Creator : Edward
 * Date : Oct, 2017
 * Description : 56. Merge Intervals
 */
public class MergeIntervals {
    /**
     * For example,
     Given [1,3],[2,6],[8,10],[15,18],
     return [1,6],[8,10],[15,18].

                sta     end
     |___|       |____|
       |_____|       |___|

     time : O(nlogn) space : O(n)

     * @param intervals
     * @return
     */
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) return intervals;
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        List<Interval> res = new ArrayList<>();
        for (Interval interval : intervals) {
            if (interval.start <= end) {
                end = Math.max(end, interval.end);
            } else {
                res.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        res.add(new Interval(start, end));
        return res;
    }
    
    
    
    public int[][] merge(int[][] arr) {
        if(arr == null || arr.length<=1)
            return arr;
        List<int[]> list = new ArrayList<>();
        Arrays.sort(arr,(a,b)->a[0]-b[0]);
        // Arrays.sort(arr,new Comparator<int[]>(){
        //     @Override
        //     public int compare(int[] a,int[] b){
        //         return a[0]-b[0];
        //     }
        // });
        int i=0;
        int n = arr.length;
        while(i<n){
            int left = arr[i][0];
            int right = arr[i][1];
            while(i<n-1 && right>=arr[i+1][0]){
                right = Math.max(right,arr[i+1][1]);
                i++;
            }
            list.add(new int[] {left,right});
            i++;
        }
        return list.toArray(new int[list.size()][2]);
    }
}
