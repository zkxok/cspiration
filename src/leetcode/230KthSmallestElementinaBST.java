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
    //中序遍历顺序的下一个结点
    int count = 0;
    int res = 0;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        helper(root);
        return res;
    }
    public void helper(TreeNode root) {
        if (root == null)
            return;
        helper(root.left);
        count--;
        if (count == 0)
            res = root.val;
        helper(root.right);
    }

    // 一个不错的解法:
    // https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/solution/javashu-de-zhong-xu-bian-li-fang-fa-di-gui-he-fei-/
    // 个人简化版
    int res;
    int count;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        helper(root);
        return res;
    }
    public void helper(TreeNode root) {
        if (root == null) return;
        helper(root.left);
        count--;
        if (count == 0) {
            res = root.val;
            return;
        }
        helper(root.right);
    }
	
    //非递归式写法
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res.get(k - 1);
    }
}
  
