class WordDictionary {
    class Node{
        Node[] childs;
        boolean isEnd;
        Node()
        {
            childs = new Node[26];
        }
        boolean find(String word,int i)
        {
            if(i == word.length())
                return isEnd;
            if(word.charAt(i) == '.')
            {
                for(Node child : childs)
                {
                    if(child != null && child.find(word,i+1))
                        return true;
                }
                return false;
            }
            else
            {
                if(childs[word.charAt(i)-'a'] == null)
                    return false;
                else    return childs[word.charAt(i)-'a'].find(word,i+1);
            }
        }
        
    }
    Node root ;
    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node curr = root;
        for(int i=0;i<word.length();i++)
        {
            char ch = word.charAt(i);
            if(curr.childs[ch-'a'] == null)
                curr.childs[ch-'a'] = new Node();
            curr = curr.childs[ch-'a'];
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        return root.find(word,0);
    }
}