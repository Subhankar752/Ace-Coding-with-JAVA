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
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int k = Integer.parseInt(s[2]);
            int[][] blocked_cells = new int[k][2];
            for(int i = 0; i < k; i++){
                String[] s1 = br.readLine().trim().split(" ");
                for(int j = 0; j < 2; j++){
                    blocked_cells[i][j] = Integer.parseInt(s1[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.FindWays(n, m, blocked_cells);
            System.out.println(ans);

        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    int mod = (int) 1e9 + 7;
    public int FindWays(int n, int m, int[][] blocked_cells)
    {
        // Code here
        long[][] mat = new long[n][m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                mat[i][j] = -1;
            }
        }
        for(int[] i : blocked_cells){
            int row = i[0] - 1;
            int col = i[1] - 1;
            mat[row][col] = 0;
        }
        if(mat[0][0] == 0 || mat[n - 1][m -1] == 0)
        return 0;
        
        mat[0][0] = 1L;
        for(int i = 1 ; i < n ; i++){
            if(mat[i][0] == 0)
            continue;
            mat[i][0] = mat[i - 1][0]; 
        }
        for(int i = 1 ; i < m ; i++){
            if(mat[0][i] == 0)
            continue;
            mat[0][i] = mat[0][i - 1];
        }
        for(int i = 1 ; i < n ; i++){
            for(int j = 1 ; j < m ; j++){
                if(mat[i][j] == 0)
                continue;
                mat[i][j] = (mat[i - 1][j] + mat[i][j - 1])%mod;
            }
        }
        return (int)(mat[n - 1][m - 1]%mod);
    }
}