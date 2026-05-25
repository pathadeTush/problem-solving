import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class TopKFrequentElement {

    // Problem: https://leetcode.com/problems/top-k-frequent-elements/

    public static void main(String[] args) {
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int num: nums) {
            freq.put(num, freq.getOrDefault(num, 0)+1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(freq.entrySet());
        list.sort(Map.Entry.comparingByValue(Collections.reverseOrder()));
        return list.stream().map(Map.Entry::getKey).mapToInt(Integer::intValue).limit(k).toArray();
    }

}
