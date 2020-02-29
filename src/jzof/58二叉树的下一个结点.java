//中序遍历顺序的下一个结点
public class Solution {
    TreeLinkNode GetNext(TreeLinkNode node) {
        if (node == null) return null;
        if (node.right != null) { // 如果有右子树，则找右子树的最左节点
            node = node.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }
        while (node.next != null) { // 没右子树，则找第一个当前节点是父节点左孩子的节点
            if (node.next.left == node) {
                // 是父节点的左孩子，则父节点是下一个,将它返回
                return node.next;
            }
            // 不是父节点的左孩子(则是右孩子),向上搜索
            node = node.next;
        }
        return null; // 退到了根节点仍没找到，则返回null
    }
}
