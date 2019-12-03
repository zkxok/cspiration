/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return helper(pre, post, 0, pre.length-1, 0);
    }
    public TreeNode helper(int[] pre,int[] post,int preStart,int preEnd,int postStart){
        if(preStart<0||preStart>preEnd)return null;
        TreeNode root=new TreeNode(pre[preStart]);
        if (preStart == preEnd)
			return root;
        int index=0;
        while(post[index]!=pre[preStart+1]){
            index++;
        }
        int offset = index-postStart+1;
        root.left=helper(pre,post, preStart+1, preStart+offset, postStart);
        root.right=helper(pre,post, preStart+1+offset, preEnd, index+1);
        return root;
    }
}
