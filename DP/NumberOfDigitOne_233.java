/**
 * https://leetcode.com/problems/number-of-digit-one/
 */
public class NumberOfDigitOne_233 {

    private static int[][] dp = new int[100][100];

    public static int countDigitOne(int n) {
        if(n == 0) {
            return 0;
        }
        if(n < 10) {
            return 1;
        }
        int totalDigit = 0;
        int num = n;
        while (num > 0) {
            totalDigit++;
            num = num / 10;
        }

        int totalOnes = 0;
        for (int digit = 1; digit < totalDigit; digit++) {
            int noOfOnes = 1;
            int totalOnesWithNumbersHavingDigit = digit*1; // case where all digits will be one
            while (noOfOnes < digit) {

                // case where first digit is not one
                int combinationsWithNoOneAtFirstDigit = nCr(digit-1, noOfOnes); // combinations where first digit is not 1

                int totalOnesWhereFirstDigitIsNotOne = combinationsWithNoOneAtFirstDigit * 8;
                int totalDigitChoiceWhereOneNotPresentExcludingFirstDigit = digit-noOfOnes-1;
                if(totalDigitChoiceWhereOneNotPresentExcludingFirstDigit > 0) {
                    totalOnesWhereFirstDigitIsNotOne *= Math.pow(9, totalDigitChoiceWhereOneNotPresentExcludingFirstDigit);
                }

                // case where first digit is one
                int combinationsWithOneAtFirstDigit = nCr(digit, noOfOnes)-nCr(digit-1, noOfOnes);
                int totalOnesWhereFirstDigitIsOne = (int) (combinationsWithOneAtFirstDigit * Math.pow(9, (digit-noOfOnes)));

                totalOnesWithNumbersHavingDigit += noOfOnes*(totalOnesWhereFirstDigitIsNotOne+totalOnesWhereFirstDigitIsOne);
                noOfOnes++;
            }
            System.out.println(digit + " -> " + totalOnesWithNumbersHavingDigit);
            totalOnes += totalOnesWithNumbersHavingDigit;
        }

        // for numbers having digits = totalDigit;
        int firstNumberWithTotalDigit = (int) Math.pow(10, totalDigit-1);
        for(int i = firstNumberWithTotalDigit; i <= n; i++) {
            totalOnes += countOneDigit(i);
        }

        return totalOnes;
    }

    // n+1Cr = nCr + nCr-1
    public static int nCr(int n, int r) {
        if(n < 1 || r < 1) {
            return 1;
        }
        if (n == 1 || n == r || r == 0) {
            dp[n][r] = 1;
        }
        if (r == 1 || r == n - 1) {
            dp[n][r] = n;
        }
        if (dp[n][r] != 0) {
            return dp[n][r];
        }

        return nCr(n - 1, r) + nCr(n - 1, r - 1);
    }

    private static int countOneDigit(int num) {
        int count = 0;
        while (num > 0) {
            if(num%10 == 1) {
                count++;
            }
            num /= 10;
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 10000;
        System.out.println(NumberOfDigitOne_233.countDigitOne(n));
    }

}
