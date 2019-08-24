package com.lgx.miaosha.test;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode{
    public int value;
    public TreeNode left;
    public TreeNode right;
    public TreeNode parent;
    public TreeNode(int value){
        this.value = value;
    }
}

public class TreeFind {

    /**
     * 层次遍历
     * @param root
     */
    public void find(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode cur = queue.remove();
            System.out.println(cur.value);
            if (cur.left != null){
                queue.add(cur.left);
            }
            if (cur.right != null){
                queue.add(cur.right);
            }
        }
    }
}
