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
    
     //非递归式写法
    public int kthLargest(TreeNode root, int k) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.right;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.left;
        }
        return res.get(k - 1);
    }
}
