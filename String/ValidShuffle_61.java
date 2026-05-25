import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ValidShuffle_61 {

    public static int sameChar1(String A, String B)
    {
        if(A.length() != B.length()) {
            return 0;
        }

        Map<Character, Integer> freq = new HashMap<>();
        for(int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            freq.put(ch, freq.getOrDefault(ch, 0)+1);
        }

        Map<Character, Integer> freq2 = new HashMap<>();
        for(int i = 0; i < B.length(); i++) {
            char ch = B.charAt(i);
            freq2.put(ch, freq2.getOrDefault(ch, 0)+1);
        }

        for(Map.Entry<Character, Integer> entry: freq.entrySet()) {
            if(!freq2.containsKey(entry.getKey()) || !Objects.equals(freq2.get(entry.getKey()), entry.getValue())) {
                return 0;
            }
        }

        return 1;
    }

    public static int sameChar(String A, String B) {
        A = A.toLowerCase();
        B = B.toLowerCase();
        int count = 0;
        for(int i = 0; i < A.length(); i++) {
            if(A.charAt(i) == B.charAt(i)) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String A = "";
        String B = "";
        System.out.println(sameChar(A, B));
    }

}
