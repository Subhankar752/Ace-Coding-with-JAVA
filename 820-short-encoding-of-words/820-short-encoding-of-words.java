class Solution {
    class TrieNode {
    public TrieNode[] children;
    public int height;
    public TrieNode() {
        children = new TrieNode[26];
        height = 0;
    }
}
   public int minimumLengthEncoding(String[] words) {
        TrieNode root = new TrieNode();
        for (String word: words) insert(root, word);
        
        Stack<TrieNode> stack = new Stack<>();
        stack.add(root);
        
        int size = 0;
        while (!stack.isEmpty()) {
            TrieNode node = stack.pop();
            int numOfChildren = 0;
            for (TrieNode child: node.children) {
                if (child == null) continue;
                numOfChildren++;
                stack.add(child);
            }
            if (numOfChildren == 0) size += node.height + 1;
        }
        
        return size;
    }
    
    private void insert(TrieNode root, String word) {
        for (int i=word.length()-1; i>=0; i--) {
            char c = word.charAt(i);
            if (root.children[c - 'a'] == null) 
                root.children[c - 'a'] = new TrieNode();
            int prevHeight = root.height;
            root = root.children[c - 'a'];
            root.height = prevHeight + 1;
        }
    }
}