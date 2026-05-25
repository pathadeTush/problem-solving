public class LargestContiguousSum_13 {

    // find maximum of sum of all possible contiguous sub arrays
    // long maxSubarraySum(int[] arr) {
    //     long maxSum = Long.MIN_VALUE;

    //     int len = arr.length;
    //     for(int i = 0; i < len; i++) {
    //         long sum = arr[i];
    //         maxSum = Math.max(maxSum, sum);
    //         for(int j = i+1; j < len; j++) {
    //             sum += arr[j];
    //             maxSum = Math.max(maxSum, sum);
    //         }
    //     }

    //     return maxSum;
    // }

    // Kedane's algo | keep adding next arr elements as sum will be max.
    // But negatives, might make it low, So take max of current contiguous sum at every point
    // Note, when sum becomes negative, don't consider that sum instead we can ignore current sum,
    // like we don't want to consider those elements which made sum negative. Initialize sum to 0
    long maxSubarraySum(int[] arr) {
        long maxSum = Long.MIN_VALUE;

        int len = arr.length;
        long sum = 0;
        for(int i = 0; i < len; i++) {
            sum += arr[i];
            maxSum = Math.max(maxSum, sum);
            if(sum < 0) {
                sum = 0;
            }
        }

        return maxSum;
    }

}

