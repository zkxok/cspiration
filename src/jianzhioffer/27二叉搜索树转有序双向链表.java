class Node {
	public int val;
	public Node left;
	public Node right;

	public Node() {
	}

	public Node(int _val) {
		val = _val;
	}

	public Node(int _val, Node _left, Node _right) {
		val = _val;
		left = _left;
		right = _right;
	}
}

public class Solution {
	// 直接用中序遍历，与LC426相同，唯一区别就是，这里不需要成环，LC需要成环
	Node head = null;
	Node realHead = null;

	public Node Convert(Node root) {//首选解法
		helper(root);
		return realHead;
	}

	private void helper(Node root) {
		if (root == null) return;
		helper(root.left);// 左
		if (head == null) {// 根
			head = root;
			realHead = root;
		} else {
			// 1,2顺序调换也一样
			head.right = root;// 1
			root.left = head;// 2
			head = root;
		}
		helper(root.right);// 右
	}
******************
	protected Node leftLast = null;
	public Node Convert2(Node root) {
		if (root == null) return null;
		if (root.left == null && root.right == null) {
			leftLast = root;// 最后的一个节点可能为最右侧的叶节点
			return root;
		}
		// 1.将左子树构造成双链表，并返回链表头节点
		Node left = Convert2(root.left);
		// 3.如果左子树链表不为空的话，将当前root追加到左子树链表
		if (left != null) {
			leftLast.right = root;
			root.left = leftLast;
		}
		leftLast = root;// 当根节点只含左子树时，则该根节点为最后一个节点
		// 4.将右子树构造成双链表，并返回链表头节点
		Node right = Convert(root.right);
		// 5.如果右子树链表不为空的话，将该链表追加到root节点之后
		if (right != null) {
			right.left = root;
			root.right = right;
		}
		return left != null ? left : root;
	}
}

