public class Main018 {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(2);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        queue.offer(6);
        queue.offer(7);
        queue.offer(8);
        queue.poll();
        while (!queue.isEmpty()) {
            System.out.print("," + queue.poll());
        }
    }
}

//原博:https://blog.csdn.net/qq_33723924/article/details/82944924
// 数组实现可扩容循环队列(Object版)
class ArrayQueue {
    private Object[] arr;// queArray
    private int capacity;// 它是数组的长度maxSize,最大能放的元素比它小1
    private int front;
    private int rear;
    // private int nItems;// 数组里元素的个数

    public ArrayQueue(int initialCapacity) {// initialCapacity:不扩容初始能存的最大元素个数
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("队列初始容量不能小于0: " + initialCapacity);
        }
        capacity = initialCapacity + 1;
        arr = new Object[capacity];
        front = 0;
        rear = 0;
        // nItems = 0;
    }

    public void offer(Object element) {
        // if (nItems == maxSize - 1)
        // expand();// 扩容
        if (isFull()) expand();
        arr[rear] = element;
        rear = (rear + 1) % capacity;
        // nItems++;
    }

    public Object poll() {
        if (isEmpty()) {
            return null;
        } else {
            Object element = arr[front];
            // arr[front] = null;
            front = (front + 1) % capacity;
            // nItems--;
            return element;
        }
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {// 空一个位置
        return ((rear + 1) % capacity) == front;// capacity==queArray.length
    }

    // 数组扩容
    private void expand() {
        int newSize = capacity * 2 + 1;// 新数组大小
        Object[] newArray = new Object[newSize];
        for (int i = 0; i < capacity; i++) {
            newArray[i] = arr[front];
            front = (front + 1) % capacity;
        }
        arr = newArray;
        front = 0;
        // 为啥是capacity - 1,因为rear是索引0开始到capacity-1,共capacity位,rear是最后一位capacity - 1,是一个空项
        rear = capacity - 1;// rear = nItems //上一次满了,那么就是只比容量小1
        capacity = newSize;
    }
    // public int getSize() {
    // return nItems;
    // }
}
