class DisjointSet {
    
    int[] par = new int[26];
    
    DisjointSet() {
        for(int i = 0; i < 26; i++) par[i] = i;
    }
    
    int findPar(int x) {
        
        if(par[x] == x) return x;
        
        return par[x] = findPar(par[x]);
        
    }
    
    void union(int x, int y) {
        
        x = findPar(x);
        y = findPar(y);
        
        if(x < y) par[y] = par[x];
        else par[x] = par[y];
    
    }
    
}

class Solution {    
    
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        
        DisjointSet ds = new DisjointSet();
        
        for(int i = 0; i < s1.length(); i++) {
            
            int x = (int)(s1.charAt(i) - 'a');
            int y = (int)(s2.charAt(i) - 'a');
            
            ds.union(x, y);
            
        }
        
        StringBuilder ans = new StringBuilder("");
        for(int i = 0; i < baseStr.length(); i++) {
            char c = (char)('a' + ds.findPar((int)(baseStr.charAt(i) - 'a')));
            ans.append(c);
        }
        
        return ans.toString();
    }

}