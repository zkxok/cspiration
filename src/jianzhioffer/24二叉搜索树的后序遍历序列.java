//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果
class Solution {
    public boolean verifyPostorder(int [] postorder) {
        if(postorder==null||postorder.length == 0) return true;
        return isTreeBST(postorder, 0, postorder.length-1);
    }
    public boolean isTreeBST(int [] sequence,int start,int end ){
        if(end <= start) return true;
        int i = start;
        for (; i < end; i++) {
            if(sequence[i] > sequence[end]) break;
        }
        for (int j = i; j < end; j++) {
            if(sequence[j] < sequence[end]) return false;
        }
        return isTreeBST(sequence, start, i-1) && isTreeBST(sequence, i, end-1);
    }
}
