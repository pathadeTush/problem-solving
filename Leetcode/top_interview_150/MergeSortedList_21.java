package top_interview_150;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class MergeSortedList_21 {

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

    //    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//        ListNode p1 = list1;
//        ListNode p2 = list2;
//        ListNode head = null;
//        ListNode pointer = null;
//        while (p1 != null && p2 != null) {
//            if(p1.val <= p2.val) {
//                if(head == null) {
//                    head = new ListNode(p1.val);
//                    pointer = head;
//                } else {
//                    pointer.next = new ListNode(p1.val);
//                    pointer = pointer.next;
//                }
//                p1 = p1.next;
//            } else {
//                if(head == null) {
//                    head = new ListNode(p2.val);
//                    pointer = head;
//                } else {
//                    pointer.next = new ListNode(p2.val);
//                    pointer = pointer.next;
//                }
//                p2 = p2.next;
//            }
//        }
//
//        while (p1 != null) {
//            if(head == null) {
//                head = new ListNode(p1.val);
//                pointer = head;
//            } else {
//                pointer.next = new ListNode(p1.val);
//                pointer = pointer.next;
//            }
//            p1 = p1.next;
//        }
//
//        while (p2 != null) {
//            if(head == null) {
//                head = new ListNode(p2.val);
//                pointer = head;
//            } else {
//                pointer.next = new ListNode(p2.val);
//                pointer = pointer.next;
//            }
//            p2 = p2.next;
//        }
//
//        return head;
//    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode p1 = list1;
        ListNode p2 = list2;
        ListNode head = null;
        ListNode prevPointer = null;
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                if (head == null) {
                    head = p1;
                    prevPointer = head;
                } else {
                    prevPointer.next = p1;
                    prevPointer = prevPointer.next;
                }
                p1 = p1.next;
            } else {
                if (head == null) {
                    head = p2;
                    prevPointer = head;
                } else {
                    prevPointer.next = p2;
                    prevPointer = prevPointer.next;
                }
                p2 = p2.next;
            }
        }

        while (p1 != null) {
            if (head == null) {
                head = p1;
                prevPointer = head;
            } else {
                prevPointer.next = p1;
                prevPointer = prevPointer.next;
            }
            p1 = p1.next;
        }

        while (p2 != null) {
            if (head == null) {
                head = p2;
                prevPointer = head;
            } else {
                prevPointer.next = p2;
                prevPointer = prevPointer.next;
            }
            p2 = p2.next;
        }

        return head;
    }

}
