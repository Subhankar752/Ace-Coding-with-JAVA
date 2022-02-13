class Solution {
    public int uniquePathsWithObstacles(int[][] a) {
        int n=a.length;
        int m=a[0].length;
        int[][] dp=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j]=0;
            }
        }
       
        for(int i=0;i<m;i++){
            if(a[0][i] == 1){
                break;
            }
            else{
                dp[0][i]=1;
            }
        }
        
        for(int i=0;i<n;i++){
            if(a[i][0] == 1){
                break;
            }
            else{
                dp[i][0]=1;
            }
        }
        
       
        
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(a[i][j]==1)
                    dp[i][j]=0;
                else
                    dp[i][j]=dp[i-1][j] + dp[i][j-1];
            }
        }
        
        return dp[n-1][m-1];
    }
}