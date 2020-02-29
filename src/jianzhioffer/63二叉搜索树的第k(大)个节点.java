class Solution {//LC是第K小,这里是第K大
    int count = 0;
    int res = 0;
    public int kthLargest(TreeNode root, int k) {
        count = k;
        helper(root);
        return res;
    }
    public void helper(TreeNode root) {
        if (root == null) return;
        helper(root.right);
        count--;
        if (count == 0) res = root.val;
        helper(root.left);
    }
}
