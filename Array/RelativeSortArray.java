import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/*
 * Problem: https://leetcode.com/problems/relative-sort-array/
 * */
public class RelativeSortArray {

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Boolean> arr2Ele = new LinkedHashMap<>();
        for (int ele : arr2) {
            arr2Ele.put(ele, true);
        }

        Map<Integer, Integer> uncommonEle = new TreeMap<>();
        Map<Integer, Integer> commonEle = new HashMap<>();
        for (int ele : arr1) {
            if (!arr2Ele.containsKey(ele)) {
                uncommonEle.put(ele, uncommonEle.getOrDefault(ele, 0) + 1);
            } else {
                commonEle.put(ele, commonEle.getOrDefault(ele, 0) + 1);
            }
        }

        int i = 0;
        for (Integer key : arr2Ele.keySet()) {
            for (int j = 0; j < commonEle.get(key); j++) {
                arr1[i++] = key;
            }
        }

        for (int ele : uncommonEle.keySet()) {
            int j = uncommonEle.get(ele);
            while (j-- > 0) {
                arr1[i++] = ele;
            }
        }

        return arr1;
    }

    public static void main(String[] args) {
        int[] arr1 = {2,21,43,38,0,42,33,7,24,13,12,27,12,24,5,23,29,48,30,31};
        int[] arr2 = {2,42,38,0,43,21};

        int[] res = relativeSortArray(arr1, arr2);
        Arrays.stream(res).forEach(ele -> System.out.print(ele + " "));
    }

}