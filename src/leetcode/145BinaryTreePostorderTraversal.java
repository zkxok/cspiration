package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Edward on 28/07/2017.
 */
public class BinaryTreePostorderTraversal {
    /**
     * 145. Binary Tree Postorder Traversal
     *
     * time : O(n);
     * space : O(n);
     * @param root
     * @return
     */
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        helper(res, root);
        return res;
    }
    public static void helper(List<Integer> res, TreeNode root) {
        if (root == null) return;
        helper(res, root.left);
        helper(res, root.right);
        res.add(root.val);
    }

    public static List<Integer> postorderTraversal2(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.addFirst(cur.val);
            if (cur.left != null) stack.push(cur.left);//左
            if (cur.right != null) stack.push(cur.right);//右
            //res.addFirst(cur.val);放在这里也一样,其实它就是模拟了栈的功能//根
        }
        return res;
    }
    
    
    **双栈法，如果要求直接输出，不是返回List<Integer> ,可以用上***
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null) return res;
        Stack<TreeNode> stack = new Stack();
        Stack<TreeNode> stack2 = new Stack();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            if(cur.left!=null) stack.push(cur.left);
            if(cur.right!=null) stack.push(cur.right);
            stack2.push(cur);
        }
        while(!stack2.isEmpty()){
            res.add(stack2.pop().val);
        }
        return res;
    }
}
