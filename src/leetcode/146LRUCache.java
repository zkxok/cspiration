package leetcode;

import java.util.HashMap;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : LRUCache
 * Creator : Edward
 * Date : Dec, 2017
 * Description : 146. LRU Cache
 */
public class LRUCache {

    /**
     * Design and implement a data structure for Least Recently Used (LRU) cache.
     * It should support the following operations: get and put.

     get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
     put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity,
     it should invalidate the least recently used item before inserting a new item.

     Follow up:
     Could you do both operations in O(1) time complexity?

     Example:

     LRUCache cache = new LRUCache( 2  capacity  );

    cache.put(1, 1);
    cache.put(2, 2);
    cache.get(1);       // returns 1
    cache.put(3, 3);    // evicts key 2
    cache.get(2);       // returns -1 (not found)
    cache.put(4, 4);    // evicts key 1
    cache.get(1);       // returns -1 (not found)
    cache.get(3);       // returns 3
    cache.get(4);       // returns 4

    HashMap + Double Linked List

     插入：1，不存在 -> capacity -> 1,head = null 2,head != null
          2，存在
     取出：1，不存在
          2，存在
     => 排序

     time : O(1)
     **/

    class Node {
        int key;
        int value;
        Node next;
        Node pre;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private HashMap<Integer, Node> map;
    private int capacity;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        head = null;
        tail = null;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        if (node != tail) {
            if (node == head) {
                head = head.next;
            } else {
                node.pre.next = node.next;
                node.next.pre = node.pre;
            }
            tail.next = node;
            node.pre = tail;
            node.next = null;
            tail = node;
        }
        return node.value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.value = value;
            if (node != tail) {
                if (node == head) {
                    head = head.next;
                } else {
                    node.pre.next = node.next;
                    node.next.pre = node.pre;
                }
                tail.next = node;
                node.pre = tail;
                node.next = null;
                tail = node;
            }
        } else {
            Node newNode = new Node(key, value);
            if (capacity == 0) {
                Node temp = head;
                head = head.next;
                map.remove(temp.key);
                capacity++;
            }
            if (head == null && tail == null) {
                head = newNode;
            } else {
                tail.next = newNode;
                newNode.pre = tail;
                newNode.next = null;
            }
            tail = newNode;
            map.put(key, newNode);
            capacity--;
        }
    }
}



*******************************

class LRUCache {
    private int cap;
	private Map<Integer, Integer> map = new LinkedHashMap<>();  // 保持插入顺序

	public LRUCache(int capacity) {
		this.cap = capacity;
	}

	public int get(int key) {
		if (map.keySet().contains(key)) {
			int value = map.get(key);
			map.remove(key);
            // 保证每次查询后，都在末尾
			map.put(key, value);
			return value;
		}
		return -1;
	}

	public void put(int key, int value) {
		if (map.keySet().contains(key)) {
			map.remove(key);
		} else if (map.size() == cap) {
			Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
			iterator.next();
			iterator.remove();
			// int firstKey = map.e***ySet().iterator().next().getValue();
			// map.remove(firstKey);
		}
		map.put(key, value);
	}
}


****
public class LRUCache {
	/**
	 * 
	 * Node类用于抽象链表的节点
	 * key、value存储键、值，
	 * before、after分别指向当前节点的前后Node节点；
	 *
	 */
	class Node {
		int key;
		int value;
		Node before;
		Node after;
	}
	
	/**
	 * 使用HashMap缓存Node节点
	 */
	private HashMap<Integer, Node> cache = new HashMap<Integer, Node>();
	/**
	 * 最大容量，超过capacity时继续插入会触发删除最老未被使用的节点
	 */
	private int capacity;
	/**
	 * 头节点、尾节点（注意这两个节点不存储实际的数据）
	 */
	private Node head, tail;

	public LRUCache(int capacity) {
		this.capacity = capacity;

		head = new Node();
		head.before = null;

		tail = new Node();
		tail.after = null;

		head.after = tail;
		tail.before = head;
	}

	/**
	 * 将节点插入队列头部
	 * 
	 * @param node
	 */
	private void addToHead(Node node) {

		node.before = head;
		node.after = head.after;
		head.after.before = node;
		head.after = node;

	}

	/**
	 * 删除队列中的一个节点
	 * 
	 * @param node
	 */
	private void removeNode(Node node) {
		Node before = node.before;
		Node after = node.after;
		before.after = after;
		after.before = before;
	}

	/**
	 * 将节点移动到有效数据头部
	 * 
	 * @param node
	 */
	private void moveToHead(Node node) {
		removeNode(node);
		addToHead(node);
	}

	/**
	 * 删除有效数据尾节点
	 * 
	 * @return 尾节点
	 */
	private Node popTail() {
		Node res = tail.before;
		this.removeNode(res);
		return res;
	}

	public int get(int key) {
		Node node = cache.get(key);
		if (node == null) {
			return -1; // should raise exception here.
		}
		// 如果获取到数据，则将获取到的节点移动到队列头部;
		moveToHead(node);
		return node.value;
	}

	public void put(int key, int value) {
		Node node = cache.get(key);
		if (node == null) {
			Node newNode = new Node();
			newNode.key = key;
			newNode.value = value;
			cache.put(key, newNode);
			addToHead(newNode);
			if (cache.size() > capacity) {
				// 删除队尾有效数据节点
				Node tail = this.popTail();
				this.cache.remove(tail.key);
			}
		} else {
			node.value = value;
			// 在使用get方法获取值之后，需要将当前获取的节点移动到队列头部
			moveToHead(node);
		}
	}
}
