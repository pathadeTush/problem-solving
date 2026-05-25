public class ReverseLinkedListI {

    // Problem: https://leetcode.com/problems/reverse-linked-list/

    public class ListNode {

        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head.next;

        while(next != null) {
            curr.next = prev;
            prev = curr;
            curr = next.next;
            next.next = prev;
            next = curr.next;
        }


        return curr;
    }

    public static class Thread1 extends Thread {
    }

}
