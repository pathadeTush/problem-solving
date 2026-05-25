package top_interview_150;

/**
 * https://leetcode.com/problems/add-two-numbers/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class AddTwoNumbers_2 {

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


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head1 = l1;
        ListNode head2 = l2;
        ListNode res = null;
        ListNode ans = null;
        int carry = 0;
        while (head1 != null && head2 != null) {
            int sum = head1.val + head2.val + carry;
            int val = sum % 10;
            carry = (sum - val) / 10;
            if (res == null) {
                res = new ListNode(val);
                ans = res;
            } else {
                res.next = new ListNode(val);
                res = res.next;
            }
            head1 = head1.next;
            head2 = head2.next;
        }

        while (head1 != null) {
            int sum = carry + head1.val;
            int val = sum % 10;
            carry = (sum - val) / 10;
            if (res == null) {
                res = new ListNode(val);
                ans = res;
            } else {
                res.next = new ListNode(val);
                res = res.next;
            }
            head1 = head1.next;
        }

        while (head2 != null) {
            int sum = carry + head2.val;
            int val = sum % 10;
            carry = (sum - val) / 10;
            if (res == null) {
                res = new ListNode(val);
                ans = res;
            } else {
                res.next = new ListNode(val);
                res = res.next;
            }
            head2 = head2.next;
        }

        if(carry != 0) {
            res.next = new ListNode(carry);
        }

        return ans;
    }

}
