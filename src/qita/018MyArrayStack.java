import java.util.Arrays;

public class Main018_MyStack {
    public static void main(String[] args) {
        MyStack<Integer> s = new MyStack<Integer>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.push(6);
        s.push(7);
        s.push(8);
        s.push(9);
        s.push(10);
        s.push(11);
        s.push(12);
        s.push(13);
        s.push(14);
        s.push(15);
        s.push(16);
        s.push(17);
        s.push(18);
        s.push(19);
        s.push(20);
        s.push(21);
        s.push(22);
        while (!s.isEmpty()) {
            System.out.print("," + s.pop());
        }
    }
}

class MyStack<E> {
    Object[] stack;
    int size;// 数组中存储元素的个数

    public MyStack() {
        stack = new Object[10];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return (E) stack[size - 1];
    }

    public E pop() {
        E e = peek();
        stack[size - 1] = null;
        size--;
        return e;
    }

    public void push(E item) {
        ensureCapacity(size + 1);// 检查容量
        stack[size++] = item;
    }

    private void ensureCapacity(int size) {
        int len = stack.length;
        if (size > len) {// 数组已满
            // 每次数组扩容为原来的2倍
            stack = Arrays.copyOf(stack, 2 * len);
        }
    }
}
