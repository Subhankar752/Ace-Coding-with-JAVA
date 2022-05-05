class Solution {
    public int longestStrChain(String[] words) {
        int n = words.length;
        int[] dp = new int[n];
        Arrays.fill(dp , 1);
        Arrays.sort(words, (aa , bb) -> aa.length() - bb.length());
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < i ; j++){
                if(solve(words[i] , words[j]))
                    dp[i] = Math.max(dp[i] , dp[j] + 1);
            }
        }
        int ans = 1;
        for(int i : dp)
            ans = Math.max(ans , i);
        return ans;
    }
    public boolean solve(String w1, String w2) {
        if(w1.length() != w2.length() + 1)
            return false;
        int p1 = 0;
        int p2 = 0;
        while(p1 < w1.length()){
            if(p2 < w2.length() && w1.charAt(p1) == w2.charAt(p2)){
                p1++;
                p2++;
            }
            else{
                p1++;
            }
        }
        if(p1 == w1.length() && p2 == w2.length())
            return true;
        return false;
    }
}