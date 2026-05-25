import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElement {

    // Problem: https://leetcode.com/problems/kth-largest-element-in-an-array/

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3,2,1,5,6,4}, 2));
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int num: nums) {
            minHeap.add(num);
            if(minHeap.size() > k) {
                minHeap.remove();
            }
        }

        return minHeap.peek();
    }

}
