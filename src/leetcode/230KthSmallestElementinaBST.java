package leetcode;

/**
 * Created by Edward on 28/07/2017.
 */
public class KthSmallestElementinaBST {
    /**
     * 230. Kth Smallest Element in a BST
     * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
     *
     *
     * time : O(n)
     * space : O(n);
     * @param root
     * @param k
     * @return
     */

	int count = 0;
	int res = 0;

	public int kthSmallest(TreeNode root, int k) {
		count = k;
		helper(root);
		return res;
	}

	public void helper(TreeNode root) {
		if (root == null) return;
		helper(root.left);
		count--;
		if (count == 0) res = root.val;
		helper(root.right);
	}
}
