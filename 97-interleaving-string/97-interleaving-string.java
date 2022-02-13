class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        int q = s3.length();
        if(n+m!=q){
            return false;
        }
        boolean dp[][]= new boolean[n+1][m+1];
        for(int i = 0;i<=n;i++){
            for(int j = 0;j<=m;j++){
                if(i==0&&j==0){
                    dp[i][j]=true;
                }
                else if(i==0){
                    char a = s3.charAt(j-1);
                    char b = s2.charAt(j-1);
                    if(a==b&&dp[i][j-1]){
                        dp[i][j]=true;
                    }
                }else if(j==0){
                    char a = s3.charAt(i-1);
                    char b = s1.charAt(i-1);
                    if(a==b&&dp[i-1][j]){
                        dp[i][j]=true;
                    }
                }else{
                    if(dp[i][j-1]&&!dp[i-1][j]){
                    char a = s2.charAt(j-1);
                    char b = s3.charAt(i+j-1);
                        if(a==b){
                            dp[i][j]=true;
                        }
                  
                }
                    else if(dp[i-1][j]&&!dp[i][j-1]){
                    char a = s1.charAt(i-1);
                    char b = s3.charAt(i+j-1);
                        if(a==b){
                            dp[i][j]=true;
                        }
                  
                }
                    else if(dp[i-1][j]&&dp[i][j-1]){
                         char a = s1.charAt(i-1);
                        char c = s2.charAt(j-1);
                    char b = s3.charAt(i+j-1);
                        if(a==b&&a==c){
                            dp[i][j]=true;
                        }
                    }
                }
                
            }
        }
       return dp[n][m]; 
    }
}