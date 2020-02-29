import java.util.PriorityQueue;
public class MedianFinder {
     //time : O(logn)
     //space : O(n)
    //题解:https://leetcode-cn.com/problems/find-median-from-data-stream/solution/you-xian-dui-lie-python-dai-ma-java-dai-ma-by-liwe/
    private int count;
    private PriorityQueue<Integer> maxheap;// 大顶堆,队头最大
    private PriorityQueue<Integer> minheap;// 小顶堆,队头最小
    public MedianFinder() {
        count = 0;
        //大顶堆的最大值<=小顶堆的最小值;且大顶堆元素个数==小顶堆元素个数，或者==小顶堆元素个数+1
        maxheap = new PriorityQueue<>((x, y) -> y - x);
        minheap = new PriorityQueue<>();// 默认小顶堆，从队头到队尾(小->大)
    }

    public void addNum(int num) {
        count += 1;
        maxheap.offer(num);
        minheap.offer(maxheap.poll());// add也可以
        // 如果两个堆合起来的元素个数是奇数，小顶堆要拿出堆顶元素给大顶堆
        if ((count & 1) != 0) {// 数据流个数加1后变成奇数个数,大顶堆的元素个数应该>小顶堆，此时大顶堆元素个数应该增加，然后变成奇数个数
            maxheap.offer(minheap.poll());// add也可以
        }
    }

    public double findMedian() {
        if ((count & 1) == 0) {// 数据流是偶数个数
            // 如果两个堆合起来的元素个数是偶数，数据流的中位数就是各自堆顶元素的平均值
            return (double) (maxheap.peek() + minheap.peek()) / 2;//等先转double之后再/2
        } else {// 数据流是奇数个数
            // 如果两个堆合起来的元素个数是奇数，数据流的中位数大顶堆的堆顶元素
            return (double) maxheap.peek();
        }
    }
}

