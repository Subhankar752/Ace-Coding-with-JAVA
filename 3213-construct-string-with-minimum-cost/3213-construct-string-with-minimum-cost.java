class Solution {
    TrieNode root;
    Integer[] dp;
    int n;

    public int minimumCost(String target, String[] words, int[] costs) {
        root = new TrieNode();
        buildTrie(words, costs); 
        
        n = target.length();
        dp = new Integer[n];

        int ans = topDownDP(target, 0);
        if (ans == Integer.MAX_VALUE) {
            ans = -1;
        }
        return ans;
    }

    public int topDownDP(String target, int currIndex) {
        if (currIndex >= n) {
            return 0;
        }
        if (dp[currIndex] != null) {
            return dp[currIndex];
        }

        int ans = Integer.MAX_VALUE;
        TrieNode currNode = root;
        
        for (int i = currIndex; i < n; i++) {
            char nextChar = target.charAt(i);
            if (!currNode.containsKey(nextChar)) {
                break;
            }
            currNode = currNode.get(nextChar);

            if (currNode.endsWord) {
                int localAns = topDownDP(target, i + 1);
                if (localAns != Integer.MAX_VALUE) {
                    localAns += currNode.cost;
                    ans = Math.min(ans, localAns);
                }
            }
        }

        dp[currIndex] = ans;
        return ans;
    }

    private void buildTrie(String[] words, int[] costs) {
        for (int i = 0; i < words.length; i++) {
            TrieNode nextNode = root;
            for (char c : words[i].toCharArray()) {
                if (!nextNode.containsKey(c)) {
                    nextNode.put(c);
                }
                nextNode = nextNode.get(c);
            }

            if (nextNode.endsWord) {
                nextNode.cost = Math.min(nextNode.cost, costs[i]);
            } else {
                nextNode.endsWord = true;
                nextNode.cost = costs[i];
            }
        }
    }

    class TrieNode {
        boolean endsWord = false;
        TrieNode[] childrenNodes;
        int cost;

        public TrieNode() {
            childrenNodes = new TrieNode[26];
        }

        public TrieNode get(Character c) {
            return childrenNodes[c - 97];
        }

        public void put(Character c) {
            if (!containsKey(c)) {
                childrenNodes[c - 97] = new TrieNode();
            }
        }

        public boolean containsKey(Character c) {
            return childrenNodes[c - 97] != null;
        }
    }
}
