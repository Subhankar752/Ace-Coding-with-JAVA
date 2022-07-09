// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            int s = Integer.parseInt(S[2]);
            int d = Integer.parseInt(S[3]);
            int[][] edges = new int[m][2];
            for(int i = 0; i < m; i++){
                String[] S1 = br.readLine().trim().split(" ");
                edges[i][0] = Integer.parseInt(S1[0]);
                edges[i][1] = Integer.parseInt(S1[1]);
            }
            Solution obj = new Solution();
            int ans = obj.possible_paths(edges, n, s, d);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int possible_paths(int[][] edges, int n, int s, int d)
    {
        int [] dp = new int [n];
        Arrays.fill(dp, -1);
        // Code here
        return solve(edges, s, d, dp);
    }
    
    int solve(int [][] edges, int s, int d, int [] dp){
        if(dp[s] != -1) return dp[s];
        
        if(s == d)
            return 1;
        
        int count = 0;
        
        for(int [] edge : edges){
            if(edge[0] == s){
                count += solve(edges, edge[1], d, dp);
            }
        }
        return count;
    }
}