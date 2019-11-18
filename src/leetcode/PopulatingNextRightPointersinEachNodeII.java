package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : PopulatingNextRightPointersinEachNodeII
 * Creator : Edward
 * Date : Oct, 2017
 * Description : 117. Populating Next Right Pointers in Each Node II
 */
public class PopulatingNextRightPointersinEachNodeII {
    /**
     * For example,
     Given the following binary tree,
          1
        /  \
       2    3
      / \    \
     4   5    7
     After calling your function, the tree should look like:
          1 -> NULL
        /  \
       2 -> 3 -> NULL
      / \    \
     4-> 5 -> 7 -> NULL

     time : O(n);
     space : O(1);

     * @param root
     */
    public void connect(TreeLinkNode root) {
        TreeLinkNode head = null;
        TreeLinkNode pre = null;
        TreeLinkNode cur = null;
        while (cur != null) {
            while (cur != null) {
                if (cur.left != null) {
                    if (pre != null) {
                        pre.next = cur.left;
                    } else head = cur.left;
                    pre = cur.left;
                }
                if (cur.right != null) {
                    if (pre != null) {
                        pre.next = cur.right;
                    } else head = cur.right;
                    pre = cur.right;
                }
                cur = cur.next;
            }
            cur = head;
            pre = null;
            head = null;
        }
    }

    public Node connect(Node root) {
        Node cur = root;
        while (cur != null) {
            Node dummy = new Node();
            Node tail = dummy;
            //遍历 cur 的当前层
            while (cur != null) {
                if (cur.left != null) {
                    tail.next = cur.left;
                    tail = tail.next;
                }
                if (cur.right != null) {
                    tail.next = cur.right;
                    tail = tail.next;
                }
                cur = cur.next;
            }
            //更新 cur 到下一层
            cur = dummy.next;
        }
        return root;
    }

    
    
    
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        // 借助队列实现层次遍历
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Node node = queue.remove();
                if (size > 0) {
                    node.next = queue.peek();
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return root;
    }
}
