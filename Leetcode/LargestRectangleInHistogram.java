import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class LargestRectangleInHistogram {

    // Problem: https://leetcode.com/problems/largest-rectangle-in-histogram/

    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{2,4}));
    }

    public static int largestRectangleArea(int[] heights) {
        int[] nextSmallerRight = nextSmallerRight(heights);
        int[] nextSmallerLeft = nextSmallerLeft(heights);
//        print(nextSmallerRight);
//        print(nextSmallerLeft);

        int maxArea = 0;
        int n = heights.length;
        for(int i = 0; i < n; i++) {
            int l = nextSmallerLeft[i]+1;
            int r = nextSmallerRight[i]-1;
            int area = heights[i]*(r-l+1);
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

// O(n^2)
//    public static int largestRectangleArea(int[] heights) {
//        int maxArea = 0;
//        int n = heights.length;
//        for(int i = 0; i < n; i++) {
//            int min = heights[i];
//            for(int j = i; j < n; j++) {
//                min = Math.min(min, heights[j]);
//                maxArea = Math.max(maxArea, min * (j-i+1));
//            }
//        }
//
//        return maxArea;
//    }

    private static int[] nextSmallerLeft(int[] heights) {
        int n = heights.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while (i < n) {
            if(!stack.isEmpty() && heights[stack.peek()] < heights[i]) {
                ans[i] = stack.peek();
                stack.push(i);
            } else {
                while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                    stack.pop();
                }

                if(!stack.isEmpty()) {
                    ans[i] = stack.peek();
                } else {
                    ans[i] = -1;
                }
                stack.push(i);
            }
            i++;
        }

        return ans;
    }

    private static int[] nextSmallerRight(int[] heights) {
        int n = heights.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        int i = n-1;
        while (i >= 0) {
            if(!stack.isEmpty() && heights[stack.peek()] < heights[i]) {
                ans[i] = stack.peek();
                stack.push(i);
            } else {
                while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                    stack.pop();
                }

                if(!stack.isEmpty()) {
                    ans[i] = stack.peek();
                } else {
                    ans[i] = n;
                }
                stack.push(i);
            }
            i--;
        }

        return ans;
    }

    private static void print(int[] heights) {
        System.out.println(Arrays.toString(heights));
    }

}
