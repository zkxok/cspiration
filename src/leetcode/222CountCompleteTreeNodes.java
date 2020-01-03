package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : CountCompleteTreeNodes
 * Creator : Edward
 * Date : Dec, 2017
 * Description : 222. Count Complete Tree Nodes
 */
public class CountCompleteTreeNodes {

    /**
     * Given a complete binary tree, count the number of nodes.

     Definition of a complete binary tree from Wikipedia:
     In a complete binary tree every level, except possibly the last, is completely filled, and all nodes
     in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

           3
         /   \
        9     20
      /  \   /  \
     15   7 1

     2^h - 1

     time : O(logn * logn)
     space : O(n) / O(logn) 不确定

     * @param root
     * @return
     */

    public int countNodes(TreeNode root) {
        // int left = helper(root, true);
        // int right = helper(root, false);
        int left = leftDepth(root);
        int right = rightDepth(root);
        if (left == right) {//左子树深度和右子树深度相等,说明是这棵树是完全二叉树
            return (1 << left) - 1;
        } else {//最后一层不满，但是倒数第2层满了,
            return 1 + countNodes(root.left) + countNodes(root.right);//根节点+递归左子树+递归右子树
        }
    }

    private int leftDepth(TreeNode root) {//这个深度包括了根节点
        int res = 0;
        while (root != null) {
            root = root.left;
            res++;
        }
        return res;
    }

    private int rightDepth(TreeNode root) {//这个深度包括了根节点
        int res = 0;
        while (root != null) {
            root = root.right;
            res++;
        }
        return res;
    }

//     private int helper(TreeNode root, boolean isLeft) {
//         if (root == null) return 0;
//         return isLeft ? helper(root.left, isLeft) + 1: helper(root.right, isLeft) + 1;
//     }
    
    ********************

    public int countNodes2(TreeNode root) {
        if (root == null) return 0;
        TreeNode left = root, right = root;
        int height = 0;
        while (right != null) {
            left = left.left;
            right = right.right;
            height++;
        }
        if (left == null)
            return (1 << height) - 1;
        return 1 + countNodes2(root.left) + countNodes2(root.right);
    }
    
   

    ***********************************************
    //*************可以，但是没有用上完全二叉树的特性*********** 
    public int countNodes4(TreeNode root) {
        if (root == null){
            return 0;
        }
        return countNodes4(root.left) + countNodes4(root.right) + 1;
    }
    
    
    
     *******最优解法************************
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int leftDepth = countLevel(root.left);//求左子树深度，不包括根节点
        int rightDepth = countLevel(root.right);//求右子树深度，不包括根节点
        if(leftDepth == rightDepth){//左子树深度和右子树深度相等,说明右子树也有节点了，那么左子树肯定满了，是一个满二叉树
            return countNodes(root.right) + (1<<leftDepth);//左子树满了，右子树可能未满，继续递归右子树
            //这里没有-1，是因为它要加上root节点，不是root.left
        }else{//最后一层不满，但是倒数第2层满了
            return countNodes(root.left) + (1<<rightDepth);//右子树是满的,左子树可能满了，也可能未满
        }
    }
    //这里是求完全二叉树的深度
    // private int countLevel(TreeNode root){
    //     int level = 0;
    //     while(root != null){
    //         level++;
    //         root = root.left;//为什么右子树也是一直遍历左节点，因为这是完全二叉树，左边的一定先有节点，然后才能轮到右边的
    //     }
    //     return level;
    // }


    private int countLevel(TreeNode root){
        if(root == null) return 0;
        return Math.max(countLevel(root.left),countLevel(root.right)) + 1;
    }
}


