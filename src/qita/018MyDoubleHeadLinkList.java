//双端链表(双头链表)
public class LinkList {
    public Node first;// 就是头结点
    public Node last;//尾节点

    public LinkList() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    // 头部添加
    public void addFirst(int val) {// insertFirst
        Node newNode = new Node(val);
        if (isEmpty())
            last = newNode;
        newNode.next = first;
        first = newNode;
    }

    // 尾部添加
    public void addLast(int val) {// insertFirst
        Node newNode = new Node(val);
        if (isEmpty()) {
            first = newNode;
        } else {
            last.next = newNode;
        }
        last = newNode;
    }

    // 移除头部
    public Node removeFirst() {// deleteFirst
        Node temp = first;
        if (first.next == null)
            last = null;
        first = first.next;
        return temp;
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
