import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Stream;

public class NextGreaterElement_I {

    // Problem: https://leetcode.com/problems/next-greater-element-i/description/

    public static void main(String[] args) {
        System.out.println(Stream.of(nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})).toList());
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> numIdxMp = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        int i = nums2.length - 1;
        numIdxMp.put(nums2[i], -1);
        stack.push(nums2[i]);

        i--;
        while (i >= 0) {
            if (stack.peek() > nums2[i]) {
                numIdxMp.put(nums2[i], stack.peek());
                stack.push(nums2[i]);
            } else {
                while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                    stack.pop();
                }

                if (!stack.isEmpty()) {
                    numIdxMp.put(nums2[i], stack.peek());
                } else {
                    numIdxMp.put(nums2[i], -1);
                }

                stack.push(nums2[i]);
                i--;
            }
        }

        int ans[] = new int[nums1.length];
        int j = 0;
        for (int num : nums1) {
            ans[j++] = numIdxMp.get(num);
        }

        return ans;
    }

}
