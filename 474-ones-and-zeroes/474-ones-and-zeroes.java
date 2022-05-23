class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        if(strs==null || m<0 || n<0) return 0;
        int[][] dp=new int[m+1][n+1];
        for(String str:strs){
            int ones=(int)str.chars().filter(num -> num=='1').count();
            int zeroes=str.length()-ones;
            for(int i=m;i>=zeroes;i--){
                for(int j=n;j>=ones;j--){
                    dp[i][j]=Math.max(dp[i][j],dp[i-zeroes][j-ones]+1);
                }
            }
        }
        return dp[m][n];
    }
}