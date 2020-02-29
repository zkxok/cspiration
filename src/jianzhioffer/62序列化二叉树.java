public class SerializeandDeserializeBinaryTree {
     // time : O(n);
     // space : O(n);
   public String serialize(TreeNode root) {
       if (root == null) return "";
       StringBuilder res = new StringBuilder();
       Queue<TreeNode> queue = new LinkedList<>();
       queue.offer(root);
       while (!queue.isEmpty()) {
           TreeNode cur = queue.poll();
           if (cur == null) {
               res.append("null ");
               continue;
           }
           res.append(cur.val + " ");
           queue.offer(cur.left);
           queue.offer(cur.right);
       }
       return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "") return null;
        String[] str = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(str[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        for (int i = 1; i < str.length; i++) {
            TreeNode cur = queue.poll();
            if (!str[i].equals("null")) {
                cur.left = new TreeNode(Integer.parseInt(str[i]));
                queue.offer(cur.left);
            }
            if (!str[++i].equals("null")) {
                cur.right = new TreeNode(Integer.parseInt(str[i]));
                queue.offer(cur.right);
            }
        }
        return root;
    }
}
