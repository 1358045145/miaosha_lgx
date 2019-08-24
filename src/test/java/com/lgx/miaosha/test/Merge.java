package com.lgx.miaosha.test;

/**
 * 合并两个有序链表
 */
public class Merge {

    public ListNode merge(ListNode head1,ListNode head2){
        if (head1 == null)
            return head2;
        if (head2 == null)
            return head1;

        if (head1.value < head2.value){
            head1.next = merge(head1.next,head2);
            return head1;
        }else {
            head2.next = merge(head1,head2.next);
            return head2;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(3);
        node1.next.next = new ListNode(5);

        ListNode node2 = new ListNode(2);
        node2.next = new ListNode(4);
        node2.next.next = new ListNode(6);

        ListNode head = new Merge().merge(node1,node2);
        while (head != null){
            System.out.print(head.value);
            head = head.next;
        }
    }
}
