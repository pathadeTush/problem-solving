package top_interview_150;

/**
 * https://leetcode.com/problems/partition-list/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class PartitionList_86 {

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

    public static ListNode partition(ListNode head, int x) {
        ListNode prevOfFirstNodeGreaterThanX = null;
        ListNode firstNodeGreaterThanX = head;
        while (firstNodeGreaterThanX != null && firstNodeGreaterThanX.val < x) {
            prevOfFirstNodeGreaterThanX = firstNodeGreaterThanX;
            firstNodeGreaterThanX = firstNodeGreaterThanX.next;
        }

        if(firstNodeGreaterThanX == null) {
            return head;
        }

        ListNode nodeLessThanX = firstNodeGreaterThanX;
        ListNode prevOfNodeLessThanX = null;
        while (firstNodeGreaterThanX != null) {
            while (nodeLessThanX != null && nodeLessThanX.val >= x) {
                prevOfNodeLessThanX = nodeLessThanX;
                nodeLessThanX = nodeLessThanX.next;
            }
            if(nodeLessThanX != null) {
                if(prevOfFirstNodeGreaterThanX == null) {
                    head = nodeLessThanX;
                } else {
                    prevOfFirstNodeGreaterThanX.next = nodeLessThanX;
                }
                prevOfNodeLessThanX.next = nodeLessThanX.next;
                nodeLessThanX.next = firstNodeGreaterThanX;
            } else {
                break;
            }

            prevOfFirstNodeGreaterThanX = nodeLessThanX;
            nodeLessThanX = prevOfNodeLessThanX;
        }

        return head;
    }

}
