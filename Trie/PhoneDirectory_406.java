import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PhoneDirectory_406 {

    static class TrieNode {
        private TrieNode[] nodes;
        private boolean isWord;

        public TrieNode() {
            this.nodes = new TrieNode[26];
        }

        public TrieNode[] getNodes() {
            return nodes;
        }

        public void setNodes(TrieNode[] nodes) {
            this.nodes = nodes;
        }

        public boolean isWord() {
            return isWord;
        }

        public void setWord(boolean word) {
            isWord = word;
        }

        public void insert(TrieNode root, String word) {
            TrieNode curr = root;
            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';
                if (curr.getNodes()[idx] == null) {
                    TrieNode node = new TrieNode();
                    curr.getNodes()[idx] = node;
                }

                curr = curr.getNodes()[idx];
            }

            if (curr != root) {
                curr.setWord(true);
            }
        }

        public boolean search(TrieNode root, String word) {
            TrieNode curr = root;
            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';
                if (curr.getNodes()[idx] == null) {
                    return false;
                }

                curr = curr.getNodes()[idx];
            }

            return curr.isWord();
        }

        public void print(TrieNode root, String word) {
            TrieNode[] nodes = root.getNodes();
            for (int i = 0; i < 26; i++) {
                TrieNode node = nodes[i];
                if (node == null) {
                    continue;
                }
                if (node.isWord()) {
                    System.out.println(word + (char) ('a' + i));
                }
                print(node, word + (char) ('a' + i));
            }
        }

    }

    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        String contact[] = in.readLine().trim().split("\\s+");
        String s = in.readLine();

        ArrayList<ArrayList<String>> ans = displayContacts(n, contact, s);
        for (int i = 0; i < ans.size(); i++) {
            for (int j = 0; j < ans.get(i).size(); j++) {
                System.out.print(ans.get(i).get(j) + " ");
            }
            System.out.println();
        }

        System.out.println("~");
    }


    public static ArrayList<ArrayList<String>> displayContacts(int n, String contacts[], String s) {
        TrieNode root = new TrieNode();
        for (String contact : contacts) {
            root.insert(root, contact);
        }

        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            prefix.append(s.charAt(i));
            ArrayList<String> list = getPrefixWords(root, prefix.toString());
            if (list.isEmpty()) {
                ans.add(new ArrayList<>(List.of("0")));
            } else {
                ans.add(getPrefixWords(root, prefix.toString()));
            }
        }

        return ans;
    }

    public static ArrayList<String> getPrefixWords(TrieNode root, String prefix) {
        TrieNode curr = root;
        ArrayList<String> ans = new ArrayList<>();

        for (char ch : prefix.toCharArray()) {
            int idx = ch - 'a';
            if (curr.getNodes()[idx] == null) {
                return new ArrayList<>();
            }

            curr = curr.getNodes()[idx];
        }

        if(curr.isWord()) {
            ans.add(prefix);
        }

        ans.addAll(getWords(curr, prefix));
        return ans;
    }

    public static ArrayList<String> getWords(TrieNode root, String word) {
        ArrayList<String> words = new ArrayList<>();

        TrieNode[] nodes = root.getNodes();
        for (int i = 0; i < 26; i++) {
            TrieNode node = nodes[i];
            if (node == null) {
                continue;
            }
            if (node.isWord()) {
                words.add(word + (char) ('a' + i));
            }

            words.addAll(getWords(node, word + (char) ('a' + i)));
        }

        return words;
    }

}
