package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : BinaryTreeMaximumPathSum
 * Creator : Edward
 * Date : Nov, 2017
 * Description : 124. Binary Tree Maximum Path Sum
 */
public class BinaryTreeMaximumPathSum {
    /**
     * Given a binary tree, find the maximum path sum.

     For this problem, a path is defined as any sequence of nodes from some starting node to any node
     in the tree along the parent-child connections. The path must contain at least one node and does not
     need to go through the root.

     For example:
     Given the below binary tree,

       1
      / \
     2   3
     Return 6.

          3
         / \
        9  20
      /  \
     15   7


     time : O(n)
     space : O(n)

     */

    //递归中利用全局变量
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        helper(root);
        return res;
    }
    public int helper(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(0, helper(root.left));
        int right = Math.max(0, helper(root.right));
        //求的过程中考虑包含当前根节点的最大路径
        res = Math.max(res, left + right + root.val);
        //只返回包含当前根节点和左子树或者右子树的路径
        return Math.max(left, right) + root.val;
    }
}
