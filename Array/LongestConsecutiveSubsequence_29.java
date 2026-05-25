import java.util.Arrays;

public class LongestConsecutiveSubsequence_29 {

    /*
     * sort array and find longest consecutive subsequence
     *  */

    static int findLongestConseqSubseq(int arr[], int n) {
        if (n < 2) {
            return n;
        }

        Arrays.sort(arr);
        int maxLength = Integer.MIN_VALUE;
        int length = 1;
        int prev = arr[0];
        for (int i = 1; i < n; i++) {
            int diff = arr[i] - prev;
            if (diff == 1) {
                length++;
            } else if (diff > 1) {
                length = 1;
            }
            prev = arr[i];
            maxLength = Math.max(maxLength, length);
        }

        return maxLength;
    }

}
