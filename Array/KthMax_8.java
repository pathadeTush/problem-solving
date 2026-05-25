import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * KthMax_8
 *
 * First solution is by sorting array
 */
public class KthMax_8 {

    public static int findKthMax(int[] arr, int k) {
        int len = arr.length;
        if(k > len) {
            return -1;
        }

        PriorityQueue<Integer> pq = new PriorityQueue(Comparator.reverseOrder());
        for (int i = 0; i < len; i++) {
            pq.add(arr[i]);
            if(pq.size() > k) {
                pq.poll();
            }
        }

        return pq.peek();
    }

}