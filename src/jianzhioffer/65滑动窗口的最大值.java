public int[] maxSlidingWindow(int[] nums, int k) {
    if (nums == null || nums.length == 0) {
        return new int[0];
    }
    //存的是数组下标,为何存数组下标,原因：下面要根据数组下标判断当前队列头部元素是否在滑动窗口内
    Deque<Integer> deque = new LinkedList<>();
    int[] res = new int[nums.length + 1 - k];
    for (int i = 0; i < nums.length; i++) {
        //deque.peekFirst()<=i-k;说明队列头部元素不在滑动窗口内,滑动窗口范围在(i-k,i]之间
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


//**剑指offer***
public ArrayList<Integer> maxInWindows(int[] nums, int size) {
    ArrayList<Integer> res = new ArrayList<Integer>();
    if (nums==null || size == 0) return res;
    Deque<Integer> deque = new LinkedList<Integer>();
    for (int i = 0; i < nums.length; i++) {
        int begin = i - size + 1;
        if (deque.isEmpty()) {
            deque.offerLast(i);// 加入队尾
        } else if (begin > deque.peekFirst()) {// 查看对头元素是否不在滑动窗口内
            deque.pollFirst();// 移除对头
        }
        //队列不为空,且队尾元素小于新元素,就把队尾元素移除
        while ((!deque.isEmpty()) && nums[deque.peekLast()] <= nums[i]) {
            deque.pollLast();// 移除队尾
        }
        deque.offerLast(i);// 加入队尾
        if (begin >= 0) {
            res.add(nums[deque.peekFirst()]);
        }
    }
    return res;
}
