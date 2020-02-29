//输入两棵二叉树A和B,判断B是不是A的子结构
class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;
        return check(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    public boolean check(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A == null || A.val != B.val) {
            return false;
        }
        return check(A.left, B.left) && check(A.right, B.right);
    }
}
    
