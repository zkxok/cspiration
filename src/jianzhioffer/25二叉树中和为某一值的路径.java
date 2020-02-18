public class Solution {
    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> list = new ArrayList<Integer>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if(root == null){
            return listAll;
        } 
        list.add(root.val);
        target -= root.val;//一直减，减到0证明刚好等于target,且没有子节点证明是一整条路径(已经到达叶结点)
        if(target == 0 && root.left == null && root.right == null){
            listAll.add(new ArrayList<Integer>(list));
        }
        FindPath(root.left, target);
        FindPath(root.right, target);
        list.remove(list.size()-1);
        return listAll;
    }
    
    ******回溯标准写法********
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
	ArrayList<ArrayList<Integer>> res = new ArrayList<>();
	helper(res, new ArrayList<>(), root, target);
	return res;
    }

    public void helper(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> tempList, TreeNode root, int target) {
	if (root == null) return;
	tempList.add(root.val);
	target -= root.val;// 一直减，减到0证明刚好等于target,且没有子节点证明是一整条路径(已经到达叶结点)
	if (target == 0 && root.left == null && root.right == null) {
	    res.add(new ArrayList<>(tempList));
	}
	helper(res, tempList, root.left, target);
	helper(res, tempList, root.right, target);
	tempList.remove(tempList.size() - 1);
     }
}
