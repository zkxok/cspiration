/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    //与剑指offer27题，唯一区别就是，剑指offer不需要成环，这里成环了
  Node first = null;//realHead
	Node last = null;//tail

	public Node treeToDoublyList(Node root) {
		if (root == null) return root;
		helper(root);
        //连接首尾元素,形成一个环
		last.right = first;
		first.left = last;
		return first;
	}

	public void helper(Node root) {
		if (root == null) return;
		helper(root.left);
		// if (last != null) {
		// 	last.right = node;
		// 	node.left = last;
		// } else {
		// 	first = node;
		// }
        if (last == null) {
			last = root;
            first = root;
		} else {
			last.right = root;
            root.left = last;
            last = root;
		}
		// last = node;
		helper(root.right);
	}
}
