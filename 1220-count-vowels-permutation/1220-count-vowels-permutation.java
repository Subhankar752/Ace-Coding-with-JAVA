class Solution {
    
    int ans = 0;
    int mod = (int)1e9 + 7;
    HashMap<Character , String> map;
    int[][] dp = new int[20001][27];
    
    public int countVowelPermutation(int n) {
        map = new HashMap<>();
        map.put('s' , "aeiou");
        map.put('a' , "e");
        map.put('e' , "ai");
        map.put('i' , "aeou");
        map.put('o' , "iu");
        map.put('u' , "a");
        
        for(int i = 0 ; i < 20001 ; i++){
            for(int j = 0 ; j < 27 ; j++){
                dp[i][j] = -1;
            }
        }
        
        ans = solve(n , 's');
        return ans;
    }
    
    public int solve(int n , char ind){
        if(n == 0)
            return 1;
     
        if(dp[n][ind - 'a'] != -1)
            return dp[n][ind - 'a'];
        
        long ans = 0;
        
        for(char c : map.get(ind).toCharArray()){
            ans += (solve(n - 1 , c)) % mod;
        }
        return dp[n][ind - 'a'] = (int)(ans % mod);
    }
}