package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : SlidingWindowMaximum
 * Creator : Edward
 * Date : Nov, 2017
 * Description : 239. Sliding Window Maximum
 */
public class SlidingWindowMaximum {
    /**
     * For example,
     Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

     Window position                Max
     ---------------               -----
     [1  3  -1] -3  5  3  6  7       3
     1 [3  -1  -3] 5  3  6  7       3
     1  3 [-1  -3  5] 3  6  7       5
     1  3  -1 [-3  5  3] 6  7       5
     1  3  -1  -3 [5  3  6] 7       6
     1  3  -1  -3  5 [3  6  7]      7
     Therefore, return the max sliding window as [3,3,5,5,6,7].

     Deque : 存的是index 从大到小排序

     time : O(n)
     space : O(n)

     * @param nums
     * @param k
     * @return
     */

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length + 1 - k];
        for (int i = 0; i < nums.length; i++) {
            if (!deque.isEmpty() && deque.peekFirst() == i - k) {
                deque.poll();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.removeLast();
            }
            deque.offerLast(i);
            if ((i + 1) >= k) {
                res[i + 1 - k] = nums[deque.peek()];
            }
        }
        return res;
    }


***************上文注释版******************
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length + 1 - k];
        for (int i = 0; i < nums.length; i++) {
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {//==也行
                deque.poll();//移除所有滑动窗口范围之外的元素,移除队头,等同于removeFirst
            }
            //必须是peekLast,不能是peekFirst和removeFirst,
            //如果是peekFirst和removeFirst，则输入[1,3,1,2,0,5],3 实际输出[3,3,1,5],正确结果:[3,3,2,5]
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.removeLast();//移除比当前元素小的所有元素,只要有当前元素在,它们就不可能是最大的
                //从末尾移除,因为队列是从大到小排列的（队头->队尾），要移除所有比当前元素小的，必然从末尾开始判断删除
            }
            deque.offerLast(i);
            if ((i + 1) >= k) {
                res[i + 1 - k] = nums[deque.peek()];//队头的元素为总是为滑动窗口最大的元素
            }
        }
        return res;
    }
}
