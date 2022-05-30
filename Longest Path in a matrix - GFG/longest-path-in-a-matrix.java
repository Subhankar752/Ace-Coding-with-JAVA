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
            int n  = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            int[][] matrix = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S2 = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    matrix[i][j] = Integer.parseInt(S2[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.longestIncreasingPath(matrix);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
   int dfs(int i, int j, int n, int m, int[][] arr, int[][] dp) {

        if (i < 0 || j < 0 || i >= n || j >= m) {
            return 0;
        }

        int maxi = 0;
        int up = 0, down = 0, right = 0, left = 0;

        
        if (dp[i][j]!=-1){
            return dp[i][j];
        }

        if ((i - 1) >= 0 && arr[i - 1][j] > arr[i][j]) {
            up = dfs(i - 1, j, n, m, arr, dp);
        }

        if ((i + 1) < n && arr[i + 1][j] > arr[i][j]) {
            down = dfs(i + 1, j, n, m, arr, dp);
        }

        if ((j - 1) >= 0 && arr[i][j - 1] > arr[i][j]) {
            right = dfs(i, j - 1, n, m, arr, dp);
        }

        if ((j + 1) < m && arr[i][j + 1] > arr[i][j]) {
            left = dfs(i, j + 1, n, m, arr, dp);
        }

        return dp[i][j] = 1 + Math.max(up, Math.max(down, Math.max(left, right)));
    }
    
    public int longestIncreasingPath(int[][] arr)
    {
        int n = arr.length;
        int m = arr[0].length;

        int maxi = 0;

        int[][] dp = new int[n][m];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int path = dfs(i, j, n, m, arr, dp);
                maxi = Math.max(maxi, path);
            }
        }

        return maxi;
    }
}