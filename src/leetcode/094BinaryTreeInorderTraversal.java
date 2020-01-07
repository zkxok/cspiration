package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Edward on 25/07/2017.
 */
public class BinaryTreeInorderTraversal {
    /**
     * 94. Binary Tree Inorder Traversal
     * Given a binary tree, return the inorder traversal of its nodes' values.
     * time : O(n)
     * space : O(n)
     * @param root
     * @return
     */

    public static List<Integer> inorderTraversal(TreeNode root) {
       List<Integer> res = new ArrayList<>();
       if (root == null) return res;
       helper(res, root);
       return res;
    }

    public static void helper(List<Integer> res, TreeNode root) {
        if (root == null) return;
        helper(res, root.left);
        res.add(root.val);
        helper(res, root.right);
    }

    public static List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;//注意中序遍历进入循环前是没有入栈操作的,它需要不断的顺着根节点找下面的节点，所以首先根节点不能为空
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();//1
            res.add(cur.val);//左根右:自身->右子节点
            cur = cur.right;//当某个节点的右子节点为null后,那么需要从栈中弹出新的节点继续遍历(1处),所以||stack!=null，当cur==null且栈空,说明中序遍历结束
        }
        return res;
    }
}
