class StreamChecker {

    class TrieNode {
        TrieNode[] children;
        boolean isLeaf;

        public TrieNode() {
            children = new TrieNode[26];
            isLeaf = false;
        }

        public void insert(String word) {
            TrieNode current = this;

            for (int i = word.length() - 1; i >= 0; i--) {
                int index = word.charAt(i) - 'a';
                if (current.children[index] == null) {
                    current.children[index] = new TrieNode();
                }

                current = current.children[index];
            }
            current.isLeaf = true;
        }

        public boolean check(List<Character> list) {
            TrieNode current = this;
            for (int i = list.size() - 1; i >= 0; i--) {
                int index = list.get(i) - 'a';
                if (current.children[index] == null) {
                    return false;
                }
                if (current.children[index].isLeaf == true) {
                    return true;
                }
                current = current.children[index];
            }
            return false;
        }
    }

    List<Character> list;
    TrieNode trie;

    public StreamChecker(String[] words) {
        trie = new TrieNode();
        list = new ArrayList<>();

        for (String s : words) {
            trie.insert(s);
        }
    }

    public boolean query(char letter) {
        list.add(letter);
        return trie.check(list);
    }
}
/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
