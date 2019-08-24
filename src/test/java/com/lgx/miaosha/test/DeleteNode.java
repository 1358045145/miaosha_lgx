package com.lgx.miaosha.test;

/**
 * O(1)的时间内删除链表中的结点
 */
public class DeleteNode {


    public ListNode deleteNode(ListNode head,ListNode node){
        if (head == null || node == null){
            return null;
        }
        //如果删除的是头结点
        if (node == head){
            head = null;
        }
        if (node.next == null){  //删除的是尾部结点
            ListNode cur = head;
            while (cur.next != node){
                cur = cur.next;
            }
            cur.next = null;
        }else {  //删除的不是尾部结点
            node.value = node.next.value;
            node.next = node.next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
//        while (head != null){
//            System.out.print(head.value + "->");
//            head = head.next;
//        }

        new DeleteNode().deleteNode(head,head);
        while (head != null){
            System.out.print(head.value + "->");
            head = head.next;
        }
    }
}

class ListNode{
    int value;
    ListNode next;
    public ListNode(int value){
        this.value = value;
    }
}

