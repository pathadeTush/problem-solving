package top_interview_150;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/happy-number/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class HappyNumber_202 {

    private Set<Integer> happyNumber = new HashSet<>();
    private Set<Integer> notAHappyNumber = new HashSet<>();
    private Set<Integer> vis;

    public boolean isHappy(int n) {
        vis = new HashSet<>();
        return solve(n);
    }

    private boolean solve(int n) {
        if (vis.contains(n) || n == 0) {
            notAHappyNumber.add(n);
            return false;
        }

        vis.add(n);
        int sum = sumOfSquaresOfDigit(n);
        if (sum == 1) {
            happyNumber.add(n);
            return true;
        } else {
            boolean res = solve(sum);
            if (res) {
                happyNumber.add(n);
            } else {
                notAHappyNumber.add(n);
            }

            return res;
        }
    }

    private int sumOfSquaresOfDigit(int n) {
        int sum = 0;
        int num = n;
        while (num > 0) {
            int rem = (num % 10);
            num /= 10;
            sum += rem * rem;
        }

        return sum;
    }

}
