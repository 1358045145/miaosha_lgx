package com.lgx.miaosha.test;

/**
 * 二叉树的镜像
 */
public class Mirror {

    public void mirror(TreeNode root){
        if (root == null)
            return ;
        //先交换两个左右子树的根节点
        swap(root);
        //递归交换左子树和右子树
        mirror(root.left);
        mirror(root.right);
    }

    private void swap(TreeNode root){
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
