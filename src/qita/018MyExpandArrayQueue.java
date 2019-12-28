public class Main {
    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<Integer>(2);
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

// 数组实现可扩容循环队列(泛型版)
class ArrayQueue<T> {
    private T[] arr;// queArray
    private int capacity;// 它是数组的长度maxSize,最大能放的元素比它小1
    private int front;
    private int rear;

    public ArrayQueue(int initialCapacity) {// initialCapacity:不扩容初始能存的最大元素个数
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("队列初始容量不能小于0: " + initialCapacity);
        }
        capacity = initialCapacity + 1;
        arr = (T[]) new Object[capacity];
        front = 0;
        rear = 0;
    }

    public void offer(T element) {
        if (isFull())
            expand();
        arr[rear] = element;
        rear = (rear + 1) % capacity;
    }

    public T poll() {
        if (isEmpty()) {
            return null;
        } else {
            T element = arr[front];
            front = (front + 1) % capacity;
            return element;
        }
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {// 空一个位置,用来方便判满
        return ((rear + 1) % capacity) == front;// capacity==queArray.length
    }

    // 数组扩容
    private void expand() {
        int newSize = capacity * 2 + 1;// 新数组大小
        T[] newArray = (T[]) new Object[newSize];
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

}
