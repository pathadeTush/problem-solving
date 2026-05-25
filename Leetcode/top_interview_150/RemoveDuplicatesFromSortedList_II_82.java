package top_interview_150;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class RemoveDuplicatesFromSortedList_II_82 {

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

    public static ListNode deleteDuplicates(ListNode head) {
        Set<Integer> duplicates = new HashSet<>();
        ListNode front = head;
        ListNode prev = null;
        while (front != null) {
            int val = front.val;
            if (front.next != null && front.next.val == val) {
                while (front.next != null && front.next.val == val) {
                    duplicates.add(val);
                    front = front.next;
                }

                if (prev == null) {
                    prev = front;
                    head = front;
                } else {
                    prev.next = front;
                }
            } else {
                prev = front;
                front = front.next;
            }
        }

        front = head;
        prev = null;
        while (front != null) {
            if (duplicates.contains(front.val)) {
                while (front != null && duplicates.contains(front.val)) {
                    front = front.next;
                }

                if (prev == null) {
                    head = front;
                } else {
                    prev.next = front;
                }
                prev = front;
                if (front != null) {
                    front = front.next;
                }
            } else {
                prev = front;
                front = front.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);

        head = RemoveDuplicatesFromSortedList_II_82.deleteDuplicates(head);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

}
