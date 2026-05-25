import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringPermutation_66 {

    /*
    Input:  ABC
    Output: ABC ACB BAC BCA CAB CBA
     */
    public static Set<String> permutation(String str) {
        if (str.isEmpty()) {
            return Collections.emptySet();
        }
        if (str.length() == 1) {
            return Collections.singleton(str);
        }

        Set<String> permutations = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            String prefix = String.valueOf(str.charAt(i));
            addAllPermutations(permutations, prefix, permutation(new StringBuilder(str).deleteCharAt(i).toString()));
        }

        return permutations;
    }

    public static void addAllPermutations(Set<String> set, String prefix, Set<String> subset) {
        for (String perm : subset) {
            set.add(prefix + perm);
        }
    }

    public static List<String> find_permutation(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        String string = new String(chars);
        List<String> ans = new ArrayList<>(permutation(string));
        Collections.sort(ans);

        return ans;
    }

    public static void main(String[] args) {
        String str = "ABC";
        System.out.println(find_permutation(str));
    }

}
