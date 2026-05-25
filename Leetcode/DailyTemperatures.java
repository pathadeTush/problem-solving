import java.util.Stack;

public class DailyTemperatures {

    // Problem: https://leetcode.com/problems/daily-temperatures/

    public static void main(String[] args) {

    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];

        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            if (!stack.isEmpty() && temperatures[stack.peek()] > temperatures[i]) {
                stack.push(i);
                ans[i] = stack.peek() - i;
            } else {
                while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                    stack.pop();
                }

                if (stack.isEmpty()) {
                    ans[i] = 0;
                } else {
                    ans[i] = stack.peek() - i;
                }
                stack.push(i);
            }
        }

        return ans;
    }

}
