/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public int maxDepth(Node root) {
        if (root == null) return 0;
        Queue<Node> quque = new LinkedList<Node>();
        quque.offer(root);
        int res = 0;
        while (!quque.isEmpty()) {
            int size = quque.size();
            for (int i = 0; i < size; i++) {//每次打印一层节点
                Node cur = quque.poll();
                for (Node node : cur.children)
                    quque.offer(node);
            }
            res++;
        }
        return res;
    }
}/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public int maxDepth(Node root) {
        if (root == null) return 0;
        Queue<Node> quque = new LinkedList<Node>();
        quque.offer(root);
        int res = 0;
        while (!quque.isEmpty()) {
            int size = quque.size();
            for (int i = 0; i < size; i++) {//每次打印一层节点
                Node cur = quque.poll();
                for (Node node : cur.children)
                    quque.offer(node);
            }
            res++;
        }
        return res;
    }
}/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public int maxDepth(Node root) {
        if (root == null) return 0;
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {//每次打印一层节点
                Node cur = queue.poll();
                for (Node node : cur.children)
                    queue.offer(node);
            }
            res++;
        }
        return res;
    }
}
