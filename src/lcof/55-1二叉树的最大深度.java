public class BinaryTreeLevelOrderTraversal {
     //time : O(n);
     //space : O(n);
    public int maxDepth(TreeNode root) {//非递归版
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level=0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            level++;
        }
        return level;
    }
     
    //递归版1
    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
    //递归版2
    public static int maxDepth2(TreeNode root) {
        if (root == null) return 0;
        int l = maxDepth2(root.left) + 1;
        int r = maxDepth2(root.right) + 1;
        return Math.max(l, r);
    }
}
