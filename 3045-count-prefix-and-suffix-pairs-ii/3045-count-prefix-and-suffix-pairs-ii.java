class Solution {

    public long countPrefixSuffixPairs(String[] words) {
        TrieNode trieNode = new TrieNode();
        long result = 0;
        for (int i = 0; i < words.length; i++) {
            result += trieNode.getPrefixLength(words[i]);
            trieNode.insert(words[i]);
        }
        return result;
    }
}

class TrieNode {
    TrieNode[] children;
    boolean isLeaf;
    int wordCount;

    public TrieNode() {
        children = new TrieNode[26];
    }

    public void insert(String word) {
        TrieNode current = this;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }

            current = current.children[index];
        }
        current.isLeaf = true;
        current.wordCount++;
    }

    public int getPrefixLength(String word) {
        TrieNode current = this;
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            sb.append(word.charAt(i));
            if (current.children[index] == null) {
                break;
            }

            current = current.children[index];
            if (current.isLeaf && word.endsWith(sb.toString())) {
                count += current.wordCount;
            }
        }
        return count;
    }
}
