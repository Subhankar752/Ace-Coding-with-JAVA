// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            
            String S = read.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.findMinInsertions(S));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    int findMinInsertions(String S){
        // code here
        String s1 = S;
        String s2 = reverse(S);
        int lcs = LCS(s1 , s2);
        return S.length() - lcs;
    }
    public String reverse(String st){
        String ans = "";
        for(int i = st.length() - 1 ; i >= 0 ; i--){
            char ch = st.charAt(i);
            ans += ch;
        }
        return ans;
    }
    public int LCS(String s1 , String s2){
        int n = s1.length();
        int[][] dp = new int[n + 1][n + 1];
        for(int i = 1 ; i < n + 1 ; i++){
            for(int j = 1 ; j < n + 1 ; j++){
                if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                else{
                    dp[i][j] = Math.max(dp[i - 1][j] , dp[i][j - 1]);
                }
            }
        }
        return dp[n][n];
    }
}