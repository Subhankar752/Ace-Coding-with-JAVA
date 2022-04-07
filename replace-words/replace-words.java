class Solution {
    public String replaceWords(List<String> dict, String sentence) {        
        Trie trie = new Trie();
        for(String word : dict)
            trie.addWord(word);
        
        String[] arr = sentence.split(" ");
        
        for(int i=0; i < arr.length; i++){
            String word = arr[i];
            String prefix = trie.prefix(word);
            if(prefix != null && !prefix.isEmpty()){
                arr[i] = prefix;
            }            
        }
        
        return String.join(" ", arr);
    }
    
    
    class Trie{
        
        Trie[] children = new Trie[26];
        String word;

        public void addWord(String word){
            Trie node = this;
            for(int i=0; i < word.length(); i++){
                char c = word.charAt(i);

                Trie node2 = node.children[c - 'a'];
                if(node.children[c - 'a'] == null )
                    node2 = new Trie();

                node.children[c - 'a'] = node2;
                node = node2;
            }
                        
            node.word = word;
        }
        
        public String prefix(String word){
            Trie node = this;
            
            for(int i=0; i < word.length(); i++){
                if(node.word != null) return node.word;
                
                char c = word.charAt(i);
                
                Trie next = node.children[c - 'a'];
                if(node.children[c - 'a'] == null){
                   return null;
                }
                
                node.children[c - 'a'] = next;
                node = next;
            }            
            return node.word;
        }
        
    }
}