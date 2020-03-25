//题解:https://leetcode-cn.com/problems/lru-cache-lcci/solution/linkedhashmap-shuang-lian-biao-hashmap-dan-lian-2/
解法一：使用LinkedHashMap
public class LRUCache{
    int capacity;
    Map<Integer, Integer> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        //先删除旧的位置，再放入新位置
        Integer value = map.remove(key);
        map.put(key, value);
        return value;
    }


    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.remove(key);
            map.put(key, value);
            return;
        }
        map.put(key, value);
        //超出capacity，删除最久没用的,利用迭代器，删除第一个
        if (map.size() > capacity) {
            map.remove(map.entrySet().iterator().next().getKey());
        }
    }
}
解法二：使用双链表+HashMap
public class LRUCache{

    //定义双向链表节点
    private class ListNode {
        int key;
        int val;
        ListNode pre;
        ListNode next;

        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
            pre = null;
            next = null;
        }
    }

    private int capacity;
    private Map<Integer, ListNode> map;     //key->node
    private ListNode head;  //dummy head
    private ListNode tail;  //dummy tail

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        ListNode node = map.get(key);
        //先把这个节点删除，再接到尾部
        node.pre.next = node.next;
        node.next.pre = node.pre;
        moveToTail(node);

        return node.val;
    }

    public void put(int key, int value) {
        //直接调用这边的get方法，如果存在，它会在get内部被移动到尾巴，不用再移动一遍,直接修改值即可
        if (get(key) != -1) {
            map.get(key).val = value;
            return;
        }
        //不存在，new一个出来,如果超出容量，把头去掉
        ListNode node = new ListNode(key, value);
        map.put(key, node);
        moveToTail(node);

        if (map.size() > capacity) {
            map.remove(head.next.key);
            head.next = head.next.next;
            head.next.pre = head;
        }
    }

    private void moveToTail(ListNode node) {
        node.pre = tail.pre;
        tail.pre = node;
        node.pre.next = node;
        node.next = tail;
    }
}
解法三：使用单链表
public class LRUCache{

    private class ListNode {
        int key, val;
        ListNode next;

        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.next = null;
        }
    }

    private int capacity;
    private Map<Integer, ListNode> map;     //key-> node.pre
    private ListNode head;  //dummy
    private ListNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new ListNode(-1, -1);
        tail = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        //map中存放的是要找的节点的前驱
        ListNode pre = map.get(key);
        ListNode cur = pre.next;

        //把当前节点删掉并移到尾部
        if (cur != tail) {
            pre.next = cur.next;
            map.put(cur.next.key, pre); //更新它后面node的前驱
            map.put(cur.key, tail);
            moveToTail(cur);
        }
        return cur.val;
    }

    public void put(int key, int value) {
        if (get(key) != -1) {
            map.get(key).next.val = value;
            return;
        }
        //不存在就new一个
        ListNode node = new ListNode(key, value);
        map.put(key, tail); //当前node的pre是tail
        moveToTail(node);

        if (map.size() > capacity) {
            map.remove(head.next.key);
            map.put(head.next.next.key, head);
            head.next = head.next.next;
        }
    }

    private void moveToTail(ListNode node) {
        node.next = null;
        tail.next = node;
        tail = tail.next;
    }
}

