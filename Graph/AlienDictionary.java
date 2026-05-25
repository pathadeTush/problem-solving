import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * https://www.geeksforgeeks.org/problems/alien-dictionary/1
 */
public class AlienDictionary {

    public static String findOrder(String[] words) {
        Set<Character> uniqueChars = new HashSet<>();
        for(String word: words) {
            for(char ch: word.toCharArray()) {
                uniqueChars.add(ch);
            }
        }
        Map<Character, List<Character>> graph = new HashMap<>();
        for(char ch: uniqueChars) {
            graph.putIfAbsent(ch, new ArrayList<>());
        }
        for(int i = 1; i < words.length; i++) {
            int m = words[i-1].length();
            int n = words[i].length();

            int l = 0;
            int r = 0;
            boolean anyOrderFound = false;
            while (l < m && r < n && words[i-1].charAt(l) == words[i].charAt(r)) {
                l++;
                r++;
            }

            if(l < m && r < n) {
                anyOrderFound = true;
                graph.get(words[i].charAt(r)).add(words[i-1].charAt(l));
                l++;
                r++;
            }
            if(!anyOrderFound && words[i-1].length() > words[i].length()) {
                return "";
            }
        }

        Set<Character> vis = new HashSet<>();
        Set<Character> pathVis = new HashSet<>();
        StringBuilder ans = new StringBuilder();
        for (Map.Entry<Character, List<Character>> entry: graph.entrySet()) {
            if(!vis.contains(entry.getKey())) {
                boolean possible = checkPossible(entry.getKey(), graph, vis, pathVis, ans);
                if(!possible) {
                    return "";
                }
            }
        }

        return ans.toString();
    }

    private static boolean checkPossible(char src, Map<Character, List<Character>> graph, Set<Character> vis, Set<Character> pathVis, StringBuilder ans) {
        vis.add(src);
        pathVis.add(src);

        for(char ng: graph.getOrDefault(src, new ArrayList<>())) {
            if(!vis.contains(ng)) {
                boolean possible = checkPossible(ng, graph, vis, pathVis, ans);
                if(!possible) {
                    pathVis.remove(src);
                    return false;
                }
            } else if(pathVis.contains(ng)) {
                pathVis.remove(src);
                return false;
            }
        }

        ans.append(src);
        pathVis.remove(src);
        return true;
    }

    public static void main(String[] args) {
//        String[] words = new String[]{"baa", "abcd", "abca", "cab", "cad"};
//        String[] words = new String[]{"caa", "aaa", "aab"};
//        String[] words = new String[]{"ab", "cd", "ef", "ad"};
//        String[] words = new String[]{"bdbc", "dbe", "bcebc", "e", "bedb"};
        String[] words = new String[]{"dddc", "a", "ad", "ab", "b", "be", "cd", "cded"};
        System.out.println(AlienDictionary.findOrder(words));
    }

}
