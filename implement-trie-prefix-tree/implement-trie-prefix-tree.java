class Trie {
    Node root;
   
    class Node{
        
    Node[] childs;
    boolean isEnd;
        
    public Node(){
        childs = new Node[26];
        isEnd = false;
        }
    }
    
    public Trie() {
        root = new Node();
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
    
    public boolean search(String word) {
        Node cur = root;
        for(char c : word.toCharArray()){
            if(cur.childs[c - 'a'] == null)
                return false;
            cur = cur.childs[c - 'a'];
        }
        return cur.isEnd;
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
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */