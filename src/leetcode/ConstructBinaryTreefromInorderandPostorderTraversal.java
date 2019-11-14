package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : ConstructBinaryTreefromInorderandPostorderTraversal
 * Creator : Edward
 * Date : Nov, 2017
 * Description : 106. Construct Binary Tree from Inorder and Postorder Traversal
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal {
    /**
     *      3
         /    \
        9     20
      /  \   /  \
     15   7 1    5

     inorder : 15 9 7 3 1 20 5
     postorder : 15 7 9 1 5 20 3

     time : O(n)
     space : O(n)
     * @param inorder
     * @param postorder
     * @return
     */

    int pInorder;
    int pPostorder;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        pInorder = inorder.length - 1;
        pPostorder = postorder.length - 1;
        return helper(inorder, postorder, null);
    }

    public TreeNode helper(int[] inorder, int[] postorder, TreeNode end) {
        if (pPostorder < 0) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[pPostorder--]);
        if (inorder[pInorder] != root.val) {
            root.right = helper(inorder, postorder, root);
        }
        pInorder--;
        if ((end == null) || (inorder[pInorder] != end.val)) {
            root.left = helper(inorder, postorder, end);
        }
        return root;
    }
    
    
    
    
    
    
    
    public TreeNode buildTree２(int[] inorder, int[] postorder) {
        return helper２(0,inorder.length-1,postorder.length-1,inorder,postorder);
    }

    public TreeNode helper２(int inStart,int inEnd,int postEnd,int[] inorder, int[] postorder){
        if(postEnd<0||inStart>inEnd){//postEnd<0||可加可不加
            return null;
        }
        TreeNode root = new TreeNode(postorder[postEnd]);//3
        int inIndex = 0;
        for(int i=inStart;i<=inEnd;i++){
            if(inorder[i]==root.val) inIndex = i;//这里注意是inorder[i]
        }
        root.left=helper(inStart,inIndex-1,postEnd - (inEnd- inIndex) - 1,inorder,postorder);//postEnd-inIndex+inStart-1会越界
        root.right=helper(inIndex+1,inEnd,postEnd-1,inorder,postorder);//preStart+inIndex-inStart+1
        return root;
    }

    
    
    
    
    public TreeNode buildTree3(int[] inorder, int[] postorder) {
        return helper3(0,inorder.length-1,postorder.length-1,inorder,postorder);
    }
    public TreeNode helper3(int inStart,int inEnd,int postEnd,int[] inorder, int[] postorder){
        if(postEnd<0||inStart>inEnd){//postEnd<0||可加可不加
            return null;
        }
        TreeNode root = new TreeNode(postorder[postEnd]);//3
        int index = 0;
        for(int i=inStart;i<=inEnd;i++){
            if(inorder[i]==root.val) index = i;//这里注意是inorder[i]
        }
        int offset = inEnd- index + 1;//postEnd - (inEnd- inIndex) - 1
        root.left=helper(inStart,index-1,postEnd - offset,inorder,postorder);//postEnd-inIndex+inStart-1会越界
        root.right=helper(index+1,inEnd,postEnd-1,inorder,postorder);//preStart+inIndex-inStart+1
        return root;
    }

    // public TreeNode buildTree(int[] inorder, int[] postorder) {
    //     return helper(inorder, postorder, postorder.length - 1, 0, inorder.length - 1);
    // }

    // public TreeNode helper(int[] inorder, int[] postorder, int postEnd, int inStart, int inEnd) {
    //     if (inStart > inEnd) {
    //         return null;
    //     }

    //     int currentVal = postorder[postEnd];
    //     TreeNode current = new TreeNode(currentVal);
        
    //     int inIndex = 0; 
    //     for (int i = inStart; i <= inEnd; i++) {
    //         if (inorder[i] == currentVal) {
    //             inIndex = i;
    //         }
    //     }
    //     TreeNode left = helper(inorder, postorder, postEnd - (inEnd- inIndex) - 1, inStart, inIndex - 1);
    //     TreeNode right = helper(inorder, postorder, postEnd - 1, inIndex + 1, inEnd);
    //     current.left = left;
    //     current.right = right;
    //     return current;
    // }
    
}
