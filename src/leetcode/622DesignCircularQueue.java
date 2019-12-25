//题解(写的非常好):https://leetcode-cn.com/problems/design-circular-queue/
public class MyCircularQueue {//美团面试考过这题，没写出来

	private int front;//指向队列头部第 1 个有效数据的位置；
	private int rear;//指向队列尾部（即最后 1 个有效数据）的下一个位置，即下一个从队尾入队元素的位置。(注意它不是指向队尾元素，而是队尾元素的下一个位置)
	private int capacity;//容量 
	private int[] arr;//用数组实现循环队列

	/**
	 * Initialize your data structure here. Set the size of the queue to be k.
	 */
	public MyCircularQueue(int k) {
		//为了避免“队列为空”和“队列为满”的判别条件冲突，我们有意浪费了一个位置,浪费一个位置是指：循环数组中任何时刻一定至少有一个位置不存放有效元素。
		capacity = k + 1;
		arr = new int[capacity];
		// 在 front 出队，故设计在数组的头部，方便删除元素
		// 删除元素的时候，只索引 +1（注意取模）

		// 在 rear 入队，故设计在数组的尾部，方便插入元素
		// 插入元素的时候，先赋值，后索引 +1（注意取模）
		front = 0;
		rear = 0;
	}

	/**
	 * Insert an element into the circular queue. Return true if the operation
	 * is successful.
	 */
	public boolean enQueue(int value) {
		if (isFull()) {//队列满了，不能加入
			return false;
		}
		arr[rear] = value;
		//入队列，队尾后移
		//为啥不是rear+1,因为任何数组一个元素都可能是队头，任何一个元素都可能是队尾
		//因为有循环的出现，要特别注意处理数组下标可能越界的情况,指针后移的时候，索引 + 1，要注意取模
		rear = (rear + 1) % capacity;//避免越界
		return true;
	}

	/**
	 * Delete an element from the circular queue. Return true if the operation
	 * is successful.
	 */
	public boolean deQueue() {
		if (isEmpty()) {
			return false;
		}
		//出队列，队头后移,队头也可能越界，所以需要取模
		front = (front + 1) % capacity;
		return true;
	}

	/**
	 * Get the front item from the queue.
	 */
	public int Front() {
		if (isEmpty()) {
			return -1;
		}
		return arr[front];//获取队头元素
	}

	/**
	 * Get the last item from the queue.
	 */
	public int Rear() {
		if (isEmpty()) {
			return -1;
		}
		//rear是指向队尾元素之后的那个空位置
		//这里不是返回arr[rear],因为rear并非是指向队尾元素的指针,它只是指向队尾下一个元素的指针
		//也不是返回arr[rear-1],也是为了避免越界,如果rear=0,那么rear-1就等于-1越界了
		return arr[(rear - 1 + capacity) % capacity];
	}

	/**
	 * Checks whether the circular queue is empty or not.
	 */
	//判别队列为空的条件是：front == rear
	public boolean isEmpty() {
		return front == rear;
	}

	/**
	 * Checks whether the circular queue is full or not.
	 */
	//判别队列为满的条件是：(rear + 1) % capacity == front;。可以这样理解，当 rear 循环到数组的前面，要从后面追上 front，还差一格的时候，判定队列为满
	public boolean isFull() {
		// 注意：这是这个经典设计的原因
		//rear是那个空格,空格再向前一位就是front了
		return (rear + 1) % capacity == front;
	}

}
