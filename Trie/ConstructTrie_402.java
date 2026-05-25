public class ConstructTrie_402 {

    public static void main(String[] args) {

        TrieNode root = new TrieNode();
        TrieNode.insert(root, "ant");
        TrieNode.insert(root, "an");
        TrieNode.insert(root, "apple");
        TrieNode.insert(root, "cat");
        TrieNode.insert(root, "bat");
        TrieNode.insert(root, "batsman");

        TrieNode.print(root, new StringBuilder(""));

//        System.out.println(TrieNode.search(root, "fjf"));
//        System.out.println(TrieNode.search(root, "cat"));

    }

    public static class TrieNode {

        private boolean isEndOfWord;
        private TrieNode[] nodes;

        public TrieNode() {
            this.isEndOfWord = false;
            this.nodes = new TrieNode[26];
        }

        public boolean isEndOfWord() {
            return isEndOfWord;
        }

        public TrieNode[] getNodes() {
            return nodes;
        }

        public void setEndOfWord(boolean endOfWord) {
            isEndOfWord = endOfWord;
        }

        public void setNodes(TrieNode[] nodes) {
            this.nodes = nodes;
        }

        public static void insert(TrieNode root, String word) {
            TrieNode curr = root;
            for (char ch : word.toCharArray()) {
                if(curr.getNodes()[ch - 'a'] == null) {
                    curr.getNodes()[ch - 'a'] = new TrieNode();
                }
                curr = curr.getNodes()[ch - 'a'];
            }

            curr.setEndOfWord(true);
        }

        public static boolean search(TrieNode root, String word) {
            TrieNode curr = root;
            for (char ch : word.toCharArray()) {
                if(curr.getNodes()[ch - 'a'] == null) {
                    return false;
                }
                curr = curr.getNodes()[ch - 'a'];
            }

            return curr.isEndOfWord();
        }

        public static void print(TrieNode root, StringBuilder word) {
            TrieNode[] nodes = root.getNodes();
            for(int i = 0; i < nodes.length; i++) {
                TrieNode curr = nodes[i];
                if(curr != null) {
                    word.append((char) (97 + i));
                    if(curr.isEndOfWord()) {
                        System.out.println(word);
                    }
                    print(curr, word);
                    word.deleteCharAt(word.length()-1);
                }
            }
        }

    }


}