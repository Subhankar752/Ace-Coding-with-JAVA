class Solution {
    
    HashSet<String> hs;
    int[] dp;
    
    public int minExtraChar(String s, String[] dictionary) {
        hs = new HashSet<>();
        dp = new int[s.length()];
        
        for(int i = 0 ; i < dp.length ; i++){
            dp[i] = -1;
        }
        
        for(String i : dictionary){
            hs.add(i);
        }
        
        return solve(s , 0);
    }
    
    public int solve(String s , int index){
        if(index == s.length())
            return 0;
        
        if(dp[index] != -1)
            return dp[index];
        
        int count = s.length() - index;
        
        for(int i = index + 1 ; i <= s.length() ; i++){
            int val = i - index;
            
            if(hs.contains(s.substring(index , i))){
                val = 0;
            }
            
            val += solve(s , i);
            count = Math.min(count , val);
        }
        
        return dp[index] = count;
    }
}