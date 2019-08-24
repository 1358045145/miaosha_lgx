package com.lgx.miaosha.test;

/**
 * 找到入环结点
 */
public class EntryNodeOfLoop {

    public ListNode getNodeOfLoop(ListNode head){
        if (head == null)
            return null;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                break;
        }
        //将快结点从头开始走
        fast = head;
        while (fast != slow){
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

}
