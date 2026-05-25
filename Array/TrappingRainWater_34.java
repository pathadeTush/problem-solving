public class TrappingRainWater_34 {

    /*
    *  trapped water at i = min(maximum at left inc i, maximum at right inc i) - arr[i]
    *   TC: O(n)  SC: O(n)
    * */
    static long trappingWater(int arr[], int n) {
        int[] leftMaximum = new int[n];
        leftMaximum[0] = arr[0];
        int max = arr[0];
        for(int i = 1; i < n; i++) {
            max = Math.max(max, arr[i]);
            leftMaximum[i] = max;
        }

        int[] rightMaximum = new int[n];
        rightMaximum[n-1] = arr[n-1];
        max = arr[n-1];
        for(int i = n-2; i >= 0; i--) {
            max = Math.max(max, arr[i]);
            rightMaximum[i] = max;
        }

        long trappedWater = 0;
        for(int i = 0; i < n; i++) {
            trappedWater += Math.min(leftMaximum[i], rightMaximum[i]) - arr[i];
        }

        return trappedWater;
    }

    public static void main(String[] args) {
        int[] arr = {8,8,2,4,5,5,1};
        System.out.println(trappingWater(arr, arr.length));
    }

}
