public static List<List<Integer>> zigzagLevelOrder3(TreeNode root) {
    List<List<Integer>> res = new ArrayList();
    if(root==null) return res;
    Queue<TreeNode> queue = new LinkedList();
    queue.offer(root);
    int level=1;
    while(!queue.isEmpty()){
        int size = queue.size();
        List<Integer> levelList = new ArrayList();
        for(int i = 0;i<size;i++){
            TreeNode cur = queue.poll();
            if(level%2!=0){
                levelList.add(cur.val);
            }else{
                levelList.add(0,cur.val);
            }
            if(cur.left!=null) queue.offer(cur.left);
            if(cur.right!=null) queue.offer(cur.right);
        }
        level++;
        res.add(levelList);
    }
    return res;
}
