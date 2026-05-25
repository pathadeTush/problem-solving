
import java.util.Arrays;


public class MinimiseMaxDiff_14 {

    /*

    sort the array
    input: 3, 9, 12, 16, 20
    k = 3, n = 5

    to reduce height difference, we can add k to all elements before mid
    and subtract k from all elements from mid to end

    But mid can't be that point always it can be any point.

    So, for each element
        add k to left elements
        subtract k from right elements

        difference of min and max at that point is the answer

        If you observer we don't have to actually add or subtract k, as array is sorted
        At any point:
            min = min(arr[i+1]-k, first+k)
            max = max(arr[i]+k, last-k)
            ans = min(ans, max-min)
     */
    public static int getMinDiff(int[] arr, int n, int k) {
        if(n < 2) {
            return 0;
        }

        Arrays.sort(arr);
        int ans = arr[n-1]-arr[0];
        for(int i = 0; i < n-1; i++) {
            int mn = Math.min(arr[i+1]-k, arr[0]+k);
            int mx = Math.max(arr[i]+k, arr[n-1]-k);
            if(mn < 0) {
                continue;
            }

            ans = Math.min(ans, mx-mn);
        }

        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {1, 5, 8, 10};
        int k = 2;

        System.out.println(MinimiseMaxDiff_14.getMinDiff(arr, arr.length, k));
    }

}
