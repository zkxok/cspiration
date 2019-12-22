/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> levelList= new ArrayList<>();
            for(int i = 0;i < size; i++){
                Node cur = queue.poll();
                levelList.add(cur.val);
                for(Node node:cur.children){
                    queue.offer(node);
                }
            }
            res.add(levelList);
        }
        return res;
    }
}
