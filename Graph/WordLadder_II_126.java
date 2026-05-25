import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode.com/problems/word-ladder-ii/description/
 */
public class WordLadder_II_126 {

    private static class Pair {
        private String word;
        private List<String> seq = new LinkedList<>();
        private int dist;

        public Pair(String word, int dist, List<String> seq) {
            this.word = word;
            this.dist = dist;
            this.seq.addAll(seq);
            this.seq.add(word);
        }

        public String getWord() {
            return word;
        }

        public int getDist() {
            return dist;
        }

        public List<String> getSeq() {
            return seq;
        }

    }

    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>();
        wordSet.add(beginWord);
        wordSet.addAll(wordList);
        if (!wordList.contains(endWord)) {
            return Collections.emptyList();
        }
        int n = wordSet.size();
        List<String> words = new ArrayList<>(wordSet);
//        Map<String, List<String>> graph = new HashMap<>(n);
//        for (String word : words) {
//            graph.putIfAbsent(word, new ArrayList<>());
//        }
//        for (int i = 0; i < n; i++) {
//            for (int j = i + 1; j < n; j++) {
//                if (isDiff1(words.get(i), words.get(j))) {
//                    graph.get(words.get(i)).add(words.get(j));
//                    graph.get(words.get(j)).add(words.get(i));
//                }
//            }
//        }

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(beginWord, 1, Collections.emptyList()));
        Map<String, Integer> dist = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            dist.put(words.get(i), Integer.MAX_VALUE);
        }
        dist.put(beginWord, 0);
        List<List<String>> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            Pair front = queue.remove();
            String word = front.getWord();
            int currDist = front.getDist();
            if(word.equals(endWord)) {
                if(ans.size() == 0 || (ans.get(0).size() == front.getSeq().size())) {
                    ans.add(front.getSeq());
                }
                continue;
            }
            // currDist exceeds ans
            if(!ans.isEmpty() && currDist >= ans.get(0).size()) {
                continue;
            }

            StringBuilder wordBuilder = new StringBuilder(word);
            for(int i = 0; i < wordBuilder.length(); i++) {
                char originalCh = wordBuilder.charAt(i);
                for(char ch = 'a'; ch <= 'z'; ch++) {
                    wordBuilder.setCharAt(i, ch);
                    if(wordSet.contains(wordBuilder.toString()) && currDist+1 <= dist.get(wordBuilder.toString())) {
                        dist.put(wordBuilder.toString(), currDist + 1);
                        queue.add(new Pair(wordBuilder.toString(), currDist + 1, front.getSeq()));
                    }
                }
                wordBuilder.setCharAt(i, originalCh);
            }
        }

        if(dist.get(endWord) == Integer.MAX_VALUE) {
            return Collections.emptyList();
        }

        return ans;
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
                String beginWord = "hit", endWord = "cog";
        List<String> wordList = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));
//        String beginWord = "hit", endWord = "cog";
//        List<String> wordList = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log"));
        System.out.println(WordLadder_II_126.findLadders(beginWord, endWord, wordList));
    }

}
