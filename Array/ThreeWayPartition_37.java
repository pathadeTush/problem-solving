import java.util.Arrays;

public class ThreeWayPartition_37 {

    public static void threeWayPartition(int arr[], int a, int b) {
        int n = arr.length;
        int countLessThanA = 0;
        int countGreaterThanB = 0;

        for (int j : arr) {
            if (j < a) {
                countLessThanA++;
            } else if (j > b) {
                countGreaterThanB++;
            }
        }

        int idx = 0;
        while (idx < n && arr[idx] < a) {
            idx++;
        }
        int l = idx;

        while (idx < countLessThanA && l < n) {
            while (l < n && arr[l] >= a) {
                l++;
            }

            if (l < n) {
                int temp = arr[idx];
                arr[idx] = arr[l];
                arr[l] = temp;
                idx++;
                l++;
            }
        }

        idx = 0;
        while (idx < n && arr[n - 1 - idx] > b) {
            idx++;
        }
        int r = n - 1 - idx;
        while (idx < countGreaterThanB && r >= 0) {
            while (r >= 0 && arr[r] <= b) {
                r--;
            }

            if (r >= 0) {
                int temp = arr[n - 1 - idx];
                arr[n - 1 - idx] = arr[r];
                arr[r] = temp;
                idx++;
                r--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 6, 2, 1};
        int a = 1, b = 3;
        threeWayPartition(arr, a, b);
        System.out.println(Arrays.toString(arr));
    }

}
