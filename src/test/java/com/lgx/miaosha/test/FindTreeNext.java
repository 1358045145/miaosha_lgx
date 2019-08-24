package com.lgx.miaosha.test;

/**
 * 寻找树的中序遍历的下一个节点
 */
public class FindTreeNext {

    public TreeNode getNext(TreeNode node){

        //如果这个节点有有右子树，那么该结点中序遍历的下一个结点就是右子树的最左边的结点
        TreeNode next = null;
        if (node.right != null){
            TreeNode cur = node.right;
            while (cur.left != null){
                cur = cur.left;
            }
            next = cur;
        }else {
            //没有右子树，判断是否是父亲结点的左孩子，或者是父亲结点的右孩子
            if (node.parent != null && node.parent.left == node ){
                next = node.parent;
            }else if (node.parent != null && node.parent.right == node){
                TreeNode parent = node.parent;
                while (parent != null){
                    node = parent;
                    parent = parent.parent;
                }
                next = node;
            }
        }
        return next;
    }

}
