package top_interview_150;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/trapping-rain-water/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class TrappingRainWater_42 {

    public static int trap(int[] height) {
        int n = height.length;
        int[] greaterElementOnLeft = new int[n];
        int[] greaterElementOnRight = new int[n];

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        greaterElementOnLeft[0] = -1;
        int i = 1;
        while (i < n) {
            while (!stack.isEmpty() && height[stack.peek()] <= height[i]) {
                stack.pop();
            }

            if(stack.isEmpty()) {
                stack.push(i);
                greaterElementOnLeft[i] = -1;
            } else {
                greaterElementOnLeft[i] = stack.peek();
            }
            i++;
        }

        stack.clear();
        stack.push(n-1);
        greaterElementOnRight[n-1] = -1;
        i = n-2;
        while (i >= 0) {
            while (!stack.isEmpty() && height[stack.peek()] <= height[i]) {
                stack.pop();
            }

            if(stack.isEmpty()) {
                stack.push(i);
                greaterElementOnRight[i] = -1;
            } else {
                greaterElementOnRight[i] = stack.peek();
            }
            i--;
        }

        System.out.println(Arrays.stream(greaterElementOnLeft).boxed().toList());
        System.out.println(Arrays.stream(greaterElementOnRight).boxed().toList());

        int ans = 0;
        for(int j = 0; j < n; j++) {
            if(greaterElementOnLeft[j] < 0 || greaterElementOnRight[j] < 0) continue;
            int heightDiff = Math.min(height[greaterElementOnLeft[j]], height[greaterElementOnRight[j]]) - height[j];
            ans += heightDiff;
        }

        return ans;
    }

    public static void main(String[] args) {
//        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
//        System.out.println(TrappingRainWater_42.trap(height));
        int[] height = new int[]{4,2,0,3,2,5};
        System.out.println(TrappingRainWater_42.trap(height));
    }

}
