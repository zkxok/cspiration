public TreeNode buildTree(int[] preorder, int[] inorder) {
    return helper(preorder,inorder,0,0,inorder.length-1);
}

public TreeNode helper(int[] preorder,int[] inorder,int preStart,int inStart,int inEnd){
    if(preStart>preorder.length-1||inStart>inEnd){//preStart>preorder.length-1||可加可不加
        return null;
    }
    TreeNode root = new TreeNode(preorder[preStart]);
    int index = 1;
    for(int i=inStart;i<=inEnd;i++){
        if(inorder[i]==root.val) index  = i;
    }
    int offset = index-inStart+1;
    root.left = helper(preorder,inorder,preStart+1,inStart,index-1);
    root.right = helper(preorder,inorder,preStart + offset,index+1,inEnd);
    return root;
}
