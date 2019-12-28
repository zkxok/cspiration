public class Main18_2 {
    public static void main(String[] args) {
        LinkList list = new LinkList();
        list.add(0, 0);
        list.add(1, 1);
        list.add(2, 2);
        list.add(3, 3);
        list.add(4, 4);
        list.add(5, 5);
        list.add(6, 6);
        list.add(7, 7);
        list.addFirst(-1);
        list.addFirst(-2);
        list.add(0, -3);
        list.add(0, -5);
        list.add(1, -4);
        list.addLast(8);
        list.addLast(9);
        list.add(0, -6);
        list.add(4, 1114);
        list.add(5, 1115);
        list.add(6, 1116);
        list.addLast(10);
        list.addLast(11);
        list.add(7, 11117);
        list.add(9, 11119);
        list.remove(9);
        list.remove(0);
        list.remove(0);
        list.remove(0);
        list.remove(1);
        list.remove(17);
        list.removeLast();
        list.removeLast();
        list.removeFirst();
        list.removeLast();
        list.dispalyList();
        list.addLast(11);
        list.dispalyList();
    }
}
// 单向单端链表
class LinkList {
    public Node first;// 就是头结点
    int size = 0;
    public LinkList() {
        first = null;
    }
    public boolean isEmpty() {
        return first == null;
    }
    public void addFirst(int val) {// insertFirst
        Node newNode = new Node(val);
        newNode.next = first;
        first = newNode;
        size++;
    }
    public void addLast(int val) {// insertFirst
        add(size, val);
    }
    public void add(int index, int val) {
        // 首先需要判断指定位置是否合法，
        if (index  size) {
            System.out.println("插入位置不合法。");
            return;
        }
        if (index == 0) {
            addFirst(val);
            return;
        }
        // 临时节点，从头节点开始
        Node temp = first;
        // 记录遍历的当前位置
        int curPos = 0;
        // 初始化要插入的节点
        Node insertNode = new Node(val);
        while (temp.next != null) {
            // 找到上一个节点的位置了
            if ((index - 1) == curPos) {
                // temp表示的是上一个节点
                // 将原本由上一个节点的指向交由插入的节点来指向
                insertNode.next = temp.next;
                // 将上一个节点的指针域指向要插入的节点
                temp.next = insertNode;
                size++;
                return;
            }
            curPos++;
            temp = temp.next;
        }
        temp.next = insertNode;
        size++;
    }
    // *****************************************
    // 删除第一个元素,并返回被删除的元素
    public Node removeFirst() {// deleteFirst
        Node temp = first;
        first = first.next;
        size--;
        return temp;
    }
    public void removeLast() {
        remove(size - 1);
    }
    public void remove(int index) {
        // 首先需要判断指定位置是否合法，
        if (index  size - 1) {
            System.out.println("插入位置不合法。");
            return;
        }
        if (index == 0) {
            removeFirst();
            return;
        }
        // 临时节点，从头节点开始
        Node temp = first;
        // 记录遍历的当前位置
        int curPos = 0;
        while (temp.next != null) {
            // 找到上一个节点的位置了
            if ((index - 1) == curPos) {
                // temp表示的是上一个节点
                // temp.next表示的是想要删除的节点
                // 将想要删除的节点存储一下
                Node deleteNode = temp.next;
                // 想要删除节点的下一个节点交由上一个节点来控制
                temp.next = deleteNode.next;
                size--;
                return;
            }
            curPos++;
            temp = temp.next;
        }
    }
    public int length() {
        int length = 0;
        // 临时节点，从首节点开始
        Node temp = first.next;
        // 找到尾节点
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }
    public void dispalyList() {
        System.out.print("first-->last");
        Node cur = first;
        while (cur != null) {
            System.out.print("," + cur.val);
            cur = cur.next;
        }
    }
    class Node {
        int val;
        Node next;
        public Node(int val) {
            this.val = val;
        }
    }
}
