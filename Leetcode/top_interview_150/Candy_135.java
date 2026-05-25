package top_interview_150;

/**
 * https://leetcode.com/problems/candy/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class Candy_135 {

        public static int candy(int[] ratings) {
        int n = ratings.length;
        int[] leftDecreasingLength = new int[n];
        int[] rightDecreasingLength = new int[n];
        int leftDecreasingCount = 0;
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                leftDecreasingCount++;
                leftDecreasingLength[i] = leftDecreasingCount;
            } else {
                leftDecreasingCount = 0;
            }
        }

        int rightDecreasingCount = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                rightDecreasingCount++;
                rightDecreasingLength[i] = rightDecreasingCount;
            } else {
                rightDecreasingCount = 0;
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.max(leftDecreasingLength[i], rightDecreasingLength[i]) + 1;
        }

        return ans;
    }

    public static void main(String[] args) {
//        int[] ratings = new int[]{1, 0, 2};
//        System.out.println(Candy_135.candy(ratings))
        int[] ratings = new int[]{1, 2, 2};
        System.out.println(Candy_135.candy(ratings));
    }

}
