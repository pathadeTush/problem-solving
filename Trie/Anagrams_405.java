import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Anagrams_405 {

    public static void main(String[] args) {
        System.out.println(anagrams(new String[]{"no", "on", "is"}));
    }

    public static ArrayList<ArrayList<String>> anagrams(String[] arr) {
        Map<String, List<String>> treeMap = new TreeMap<>();
        for (String str : arr) {
            char[] strArr = str.toCharArray();
            Arrays.sort(strArr);
            String sortedString = new String(strArr);
            if (treeMap.containsKey(sortedString)) {
                treeMap.get(sortedString).add(str);
            } else {
                treeMap.put(sortedString, new ArrayList<>(List.of(str)));
            }
        }

        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        for(List<String> list: treeMap.values()) {
            ans.add(new ArrayList<>(list));
        }

        return ans;
    }

}
