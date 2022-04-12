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
            String[] S1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            int[][] edges = new int[m][3];
            for(int i = 0; i < m; i++){
                String S2[] = br.readLine().trim().split(" ");
                for(int j = 0; j < 3; j++)
                    edges[i][j] = Integer.parseInt(S2[j]);
            }
            Solution obj = new Solution();
            int ans = obj.isNegativeWeightCycle(n, edges);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int isNegativeWeightCycle(int n, int[][] edges)
    {
        //code here
        int[]dis = new int[n];
        for(int i = 0 ; i < n ; i++){
            dis[i] = Integer.MAX_VALUE;
        }
        dis[0] = 0;
        
        for(int i = 0 ; i <= n - 1 ; i++){
            for(int j = 0 ; j < edges.length ; j++){
                if( dis[edges[j][0]] != Integer.MAX_VALUE && dis[edges[j][0]] + edges[j][2] < dis[edges[j][1]]){
                    dis[edges[j][1]] = dis[edges[j][0]] + edges[j][2];
                }
            }
        }
        
        for(int i = 0 ; i < edges.length ; i++){
            if( dis[edges[i][0]] + edges[i][2] < dis[edges[i][1]]){
                return 1;
            }
        }
            
        return 0;
    }
}