package top_interview_150;

/**
 * https://leetcode.com/problems/rotate-list/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class RotateList_61 {

    public static class ListNode {
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

    public static ListNode rotateRight(ListNode head, int k) {
        int len = 0;
        ListNode prev = null;
        ListNode pointer = head;
        while (pointer != null) {
            prev = pointer;
            pointer = pointer.next;
            len++;
        }

        if(len < 2 || (k % len) == 0) {
            return head;
        }

        int rotateCount = k%len;

        ListNode last = prev;
        pointer = head;
        ListNode newLast = null;
        for(int i = 0; i < len-rotateCount; i++) {
            newLast = pointer;
            pointer = pointer.next;
        }

        last.next = head;
        ListNode newHead = newLast.next;
        newLast.next = null;

        return newHead;
    }

}
