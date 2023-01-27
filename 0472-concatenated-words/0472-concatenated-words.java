class Trie{
    public Trie[] next = new Trie[26];
    public boolean end = false;
    public Trie(){}
}
class Solution {
    Trie trie;
    private boolean dfs(String word, int i,Trie node, int count){
        if(i == word.length()){
            return count >= 2;
        }
        for(;i < word.length();++i ){
            node =  node.next[word.charAt(i) - 'a'];
            if(node == null) return false;
            else if(node.end && dfs(word,i+1,trie,count+1)) return true;
        }
        return false;
    }
    
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        trie = new Trie();
        for(String word : words){
            Trie current = trie;
            for(int i = 0 ; i <  word.length() ; ++i){
                if(current.next[word.charAt(i) - 'a'] == null){
                    current.next[word.charAt(i) - 'a'] = new Trie();
                }
                current = current.next[word.charAt(i) - 'a'];
            }
            current.end = true;
        }
        List<String> ans = new ArrayList<String>();
        
        for(String word : words){
            if(dfs(word,0,trie,0)) ans.add(word);
        }
        return ans;
    }
}