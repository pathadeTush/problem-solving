public class CountInversion_21 {

    // Brute force, count inversion for each element
    public static long inversionCountBruteForce(long[] arr, int n) {
        long count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    count++;
                }
            }
        }

        return count;
    }

    /*
     * Intuition: if we have 2 sorted array, then we can find inversion count in O(n)
     * So, break down array into smaller sub array, count inversion count for them and merge them in sorted array
     *
     * Use merge sort
     * */
    public static long merge(long[] arr, int l, int mid, int r) {
        long count = 0;
        long[] sortedArr = new long[r - l + 1];
        int i = l;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= r) {
            if (arr[i] <= arr[j]) {
                sortedArr[k] = arr[i];
                i++;
            } else {
                sortedArr[k] = arr[j];
                count += mid - i + 1;
                j++;
            }
            k++;
        }

        while (i <= mid) {
            sortedArr[k] = arr[i];
            i++;
            k++;
        }

        while (j <= r) {
            sortedArr[k] = arr[j];
            j++;
            k++;
        }

        if (k >= 0) {
            System.arraycopy(sortedArr, 0, arr, l, k);
        }

        return count;
    }

    public static long inversionCount(long[] arr, int l, int r) {
        int mid = (l + r) >> 1;
        long count = 0;
        if (l > r) {
            return count;
        }

        count += inversionCount(arr, l, mid);
        count += inversionCount(arr, mid + 1, r);
        count += merge(arr, l, mid, r);

        return count;
    }

}
