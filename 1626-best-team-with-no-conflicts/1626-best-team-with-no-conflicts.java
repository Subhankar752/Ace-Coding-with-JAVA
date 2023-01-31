class Solution {
    
    class Pair{
        int a;
        int b;
        Pair(int a , int b){
            this.a = a;
            this.b = b;
        }
    }
    
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        Pair[] p = new Pair[n];
        
        for(int i = 0 ; i < n ; i++){
            p[i] = new Pair(ages[i] , scores[i]);
        }
        
        Arrays.sort(p , (aa , bb) -> aa.a != bb.a ? aa.a - bb.a : aa.b - bb.b);
        
        long ans = 0;
        long[] dp = new long[n];
        
        for(int i = 0 ; i < n ; i++){
            dp[i] = p[i].b;
            for(int j = 0 ; j < i ; j++){
                if(p[i].b >= p[j].b)
                    dp[i] = Math.max(dp[i] , dp[j] + p[i].b);
            }
            ans = Math.max(ans , dp[i]);
        }
        
        return (int) ans;
    }
}