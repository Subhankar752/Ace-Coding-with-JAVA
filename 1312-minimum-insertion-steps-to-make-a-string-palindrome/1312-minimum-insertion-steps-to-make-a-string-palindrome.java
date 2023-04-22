class Solution {
    public int minInsertions(String s) {
        Integer[][] dp = new Integer[s.length()][s.length()];
        return find(0,s.length()-1,s,dp);
    }

    public int find(int i,int j,String s,Integer[][] dp){
        if(i==j || i>j){
            return 0;
        }   
        if(dp[i][j] != null){
            return dp[i][j];
        }
        int ans = 0;
        if(s.charAt(i) == s.charAt(j)){            
            ans =  find(i+1,j-1,s,dp);
        }else{
            ans = 1 + Math.min(find(i+1,j,s,dp),find(i,j-1,s,dp));            
        }        
        return dp[i][j] = ans;
    }
}