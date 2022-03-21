class Solution {
    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        
        
        
        //filling dp table like knapsack
        int dp[][]=new int[numArrows+1][aliceArrows.length+1];
        
        for(int i=1;i<=numArrows;i++){
            
            for(int j=1;j<aliceArrows.length;j++){
                
                
                dp[i][j]=dp[i][j-1];
                if(i>=aliceArrows[j]+1){
                    
                    dp[i][j]=Math.max(dp[i-aliceArrows[j]-1][j-1]+j,dp[i][j]);
                }
                
            }
        }
        
        
        int ans[]=new int[aliceArrows.length];
        
        int i=numArrows;
        int j=aliceArrows.length-1;
        
        //backtracking to fill the arrows shot by bob;
        int sum=0;
        for(int k=aliceArrows.length-1;k>0;k--){
            
            
            if(i>=aliceArrows[j]+1 && dp[i-aliceArrows[j]-1][j-1]+j>dp[i][j-1]){
                
                ans[k]=aliceArrows[k]+1;
                i=i-aliceArrows[j]-1;
                j=j-1;
            }
            else{
                ans[k]=0;
                j=j-1;
            }
            
            sum+=ans[k];
        }
        
        
        //throwing remaining arrows at 0th target.
        ans[0]=numArrows-sum;
        
        
        return ans;
    }
}