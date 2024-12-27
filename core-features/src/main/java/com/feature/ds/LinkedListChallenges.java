package com.feature.ds;

public class LinkedListChallenges {

    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(1, new ListNode(2 , new ListNode(4)));
        ListNode listNode2 = new ListNode(1, new ListNode(3 , new ListNode(4)));
        print(mergeTwoLists(listNode1, listNode2));

        print(removeElements(listNode1, 4));

        print(reverseList(listNode1));
    }

    public static ListNode removeElements(ListNode head, int val) {
        if ( head == null) return null;
        ListNode p = removeElements(head.next, val);
        if (head.val == val)
            return p;
        head.next = p;
        return head;
    }

    public static void print(ListNode head) {
        System.out.println(" ************************************************** ");
        ListNode h = head;
        while (h != null) {
            System.out.println(h.val);
            h = h.next;
        }
    }

    public static ListNode reverseList(ListNode head) {

        ListNode h = head;
        ListNode tail = null;

        while (h != null) {

            ListNode next = h.next;
            h.next = tail;
            tail = h;
            h = next;

        }

        return tail;
    }

    public static boolean hasCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        while (slow != null && fast != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next;
            if (fast != null)
                fast = fast.next;
        }
        return false;
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode result = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                result.next = list1;
                list1 = list1.next;
            } else {
                result.next = list2;
                list2 = list2.next;
            }
            result = result.next;
        }

        while (list1 != null) {
            result.next = list1;
            result = result.next;
            list1 = list1.next;
        }

        while (list2 != null) {
            result.next = list2;
            result = result.next;
            list2 = list2.next;
        }

        return head.next;
    }

}


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}