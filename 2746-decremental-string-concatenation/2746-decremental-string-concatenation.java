class Solution {
    
    int[][][] dp;
    
    public int minimizeConcatenatedLength(String[] words) {
        dp = new int[words.length + 1][26][26];
        
        return words[0].length() + solve(words , 1 , words[0].charAt(0) , words[0].charAt(words[0].length() - 1));
    }
    
    public int solve(String[] words , int i, char start , char end) {
        if(i >= words.length)
            return 0;
        
        if(dp[i][start - 'a'][end - 'a'] != 0)
            return dp[i][start - 'a'][end - 'a'];
        
        char s = words[i].charAt(0);
        char e = words[i].charAt(words[i].length() - 1);
        
        int len1 = words[i].length();
        int len2 = words[i].length();
        
        if(end == s){
            len1--;
        }
        
        if(start == e){
            len2--;
        }
        
        int x = len1 + solve(words , i + 1 , start , e);
        int y = len2 + solve(words , i + 1 , s , end);
        
        return dp[i][start - 'a'][end - 'a'] = Math.min(x , y);
    }
}