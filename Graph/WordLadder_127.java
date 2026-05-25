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
 * https://leetcode.com/problems/word-ladder/description/
 */
public class WordLadder_127 {

    private static class Pair {
        private String word;
        private int dist;

        public Pair(String word, int dist) {
            this.word = word;
            this.dist = dist;
        }

        public String getWord() {
            return word;
        }

        public int getDist() {
            return dist;
        }
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>();
        wordSet.add(beginWord);
        wordSet.addAll(wordList);
        if(!wordList.contains(endWord)) {
            return 0;
        }
        int n = wordSet.size();
        List<String> words = new ArrayList<>(wordSet);
        Map<String, List<String>> graph = new HashMap<>(n);
        for (String word: words) {
            graph.putIfAbsent(word, new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isDiff1(words.get(i), words.get(j))) {
                    graph.get(words.get(i)).add(words.get(j));
                    graph.get(words.get(j)).add(words.get(i));
                }
            }
        }

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(beginWord, 1));
        Map<String, Integer> dist = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            dist.put(words.get(i), Integer.MAX_VALUE);
        }
        dist.put(beginWord, 0);
        while (!queue.isEmpty()) {
            Pair front = queue.remove();
            String word = front.getWord();
            int currDist = front.getDist();
            for (String ng : graph.get(word)) {
                if (currDist + 1 < dist.get(ng)) {
                    dist.put(ng, currDist + 1);
                    queue.add(new Pair(ng, currDist + 1));
                }
            }
        }

        return dist.get(endWord) == Integer.MAX_VALUE ? 0 : dist.get(endWord);
    }

    private static boolean isDiff1(String word1, String word2) {
        int diff = 0;
        int i = 0, n = word1.length();
        while (i < n) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diff++;
            }
            if (diff > 1) {
                return false;
            }
            i++;
        }

        return diff == 1;
    }

    public static void main(String[] args) {
//        String beginWord = "hit", endWord = "cog";
//        List<String> wordList = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log"));
        System.out.println(WordLadder_127.ladderLength(beginWord, endWord, wordList));
    }

}
