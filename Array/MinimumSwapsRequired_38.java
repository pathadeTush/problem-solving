public class MinimumSwapsRequired_38 {

    /*
    Intuition: after swapping subarray will have length = total Element less than k = Lets say m
    now, iterate over all possible window/sub array of length m
    min swaps = minimum unwanted elements (as we are going to swap them)
     */
    public static int minSwap(int arr[], int n, int k) {
        int totalEleLessThanK = 0;
        for (int ele : arr) {
            if (ele <= k) {
                totalEleLessThanK++;
            }
        }

        int prevWindowSwapCnt = 0;
        for(int i = 0; i < totalEleLessThanK; i++) {
            if(arr[i] > k) {
                prevWindowSwapCnt++;
            }
        }

        int minSwap = prevWindowSwapCnt;
        for(int i = totalEleLessThanK; i < n; i++) {
            int minSwapForCurrentWindow;
            if(arr[i-totalEleLessThanK] > k) {
                minSwapForCurrentWindow = prevWindowSwapCnt-1;
            } else {
                minSwapForCurrentWindow = prevWindowSwapCnt;
            }

            if(arr[i] > k) {
                minSwapForCurrentWindow++;
            }

            minSwap = Math.min(minSwap, minSwapForCurrentWindow);
            prevWindowSwapCnt = minSwapForCurrentWindow;
        }

        return minSwap;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 6, 3};
        int k = 3;
        System.out.println(minSwap(arr, arr.length, k));
    }

}
