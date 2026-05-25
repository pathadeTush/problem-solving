package top_interview_150;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/?envType=study-plan-v2&envId=top-interview-150
 */
public class RemoveNthNodeFromEndOfList_19 {

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

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode front = head;
        while (front != null) {
            len++;
            front = front.next;
        }

        if(n > len) {
            return head;
        }

        front = head;
        ListNode prev = null;
        for(int i = 0; i < len-n; i++) {
            prev = front;
            front = front.next;
        }

        if(prev != null) {
            if(front != null) {
                prev.next = front.next;
            } else {
                prev.next = null;
            }

            return head;
        } else {
            return front.next;
        }
    }

}
