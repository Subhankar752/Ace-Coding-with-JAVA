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
            int n = Integer.parseInt(br.readLine().trim());
            int[][] matrix = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++)
                    matrix[i][j] = Integer.parseInt(s[j]);
            }
            Solution obj = new Solution();
            int[] ans = obj.FindWays(matrix);
            for(int i = 0; i < ans.length; i++){
                System.out.print(ans[i] + " ");
            }
            System.out.println();

        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int[] FindWays(int[][] maze)
    {
        // Code here
        int MOD = (int)1e9 + 7;
        int N = maze.length;
        int path[][] = new int[N][N];
        int cost[][] = new int[N][N];

        path[0][0] = 1;
        cost[0][0] = maze[0][0];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                if (i == 0 && j == 0)
                    continue;

                int x, y, m1, m2;

                //for row change
                if (i > 0 && (maze[i - 1][j] == 2 || maze[i - 1][j] == 3)) {
                    x = path[i - 1][j];
                    m1 = cost[i - 1][j];
                } else {
                    x = 0;
                    m1 = 0;
                }


                //for column change
                if (j > 0 && (maze[i][j - 1] == 1 || maze[i][j - 1] == 3)) {
                    y = path[i][j - 1];
                    m2 = cost[i][j - 1];
                } else {
                    y = 0;
                    m2 = 0;
                }

                path[i][j] = (int) ((x % MOD + y % MOD) % MOD);

                if (m1 != 0 || m2 != 0) {

                    cost[i][j] = Math.max(m1, m2) + maze[i][j];
                } else {
                    cost[i][j] = 0;
                }
            }
        }
        int a = path[N - 1][N - 1];
        int b = cost[N - 1][N - 1];
        int[] ans = new int[2];
        ans[0] = a;
        ans[1] = b;
        return ans;
    }
}