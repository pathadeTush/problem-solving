import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class RepeatedWordInStringArr_84 {

    static String secFrequent(String[] arr, int n)
    {
        if(n < 2) {
            return "";
        }

        Map<String, Integer> wordFreq = new HashMap<>();
        Map<Integer, String> freqWord = new TreeMap<>(Collections.reverseOrder());
        for(String word: arr) {
            wordFreq.put(word, wordFreq.getOrDefault(word, 0)+1);
        }
        for(Map.Entry<String, Integer> entry: wordFreq.entrySet()) {
            freqWord.put(entry.getValue(), entry.getKey());
        }
        freqWord.remove(freqWord.entrySet().stream().findFirst().get().getKey());

        return freqWord.entrySet().stream().findFirst().get().getValue();
    }

    public static void main(String[] args) {
        String[] arr = {"aaa", "bbb", "ccc", "bbb", "aaa", "aaa"};
        System.out.println(secFrequent(arr, arr.length));
    }

}
