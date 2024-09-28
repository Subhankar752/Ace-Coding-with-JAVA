class Solution {
    Node root;
   
    class Node {
        
    Node[] childs;
    boolean isEnd;
        
    public Node() {
        childs = new Node[26];
        isEnd = false;
        }
    }
    
    public void insert(String word) {
        Node cur = root;
        for(char c : word.toCharArray()){
            if(cur.childs[c - 'a'] == null){
                cur.childs[c - 'a'] = new Node();
            }
            cur = cur.childs[c - 'a'];
        }
        cur.isEnd = true;
    }
    
    public boolean startsWith(String word) {
        Node cur = root;
        for(char c : word.toCharArray()){
            if(cur.childs[c - 'a'] == null)
                return false;
            cur = cur.childs[c - 'a'];
        }
        return true;
    }
    
    Integer[] dp;

    public int minValidStrings(String[] words, String target) {
        this.root = new Node();
        for (String word : words) {
            insert(word);
        }
        
        dp = new Integer[target.length()];
        return solve(0, words, target);
    }

    public int solve(int idx, String[] words, String target) {
        if (idx == target.length()) {
            return 0;
        }
        
        if (dp[idx] != null) {
            return dp[idx];
        }

        int ans = Integer.MAX_VALUE;
        Node temp = root;
        for (int i = idx; i < target.length(); i++) {
            int idx1 = target.charAt(i) - 'a';
            if (temp.childs[idx1] == null) break;
            temp = temp.childs[idx1];
            
            int res = solve(i + 1, words, target);
            if (res != -1) {
                ans = Math.min(ans, res + 1);
            }
            
        }

        return dp[idx] = ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public boolean check(String temp, String[] words) {
        int len = temp.length();
        
        for (String s : words) {
            if (s.startsWith(temp)) {
                return true;
            }
        }
        
        return false;
    }
}
