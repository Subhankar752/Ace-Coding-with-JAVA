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
            int m = Integer.parseInt(S[0]);
            int n = Integer.parseInt(S[1]);
            int[][] matrix = new int[m][n];
            for(int i = 0; i < m; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++)
                    matrix[i][j] = Integer.parseInt(s[j]);
            }
            Solution obj = new Solution();
            int ans = obj.MaxGold(matrix);
            System.out.println(ans);

        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int MaxGold(int[][] matrix)
    {
        // Code here
        int rows = matrix.length;
        int cols = matrix[0].length;

        for(int i = 1 ; i < rows ; i++){
            for(int j = 0 ; j < cols ; j++){
                 int a = -1 , b = -1 , c=-1;
           if(matrix[i][j] == -1)
            continue;
           if(i - 1 >= 0 && j - 1 >= 0 && matrix[i - 1][j - 1] != -1)
            a = matrix[i - 1][j - 1];
            
           if(i - 1 >= 0 && matrix[i - 1][j] != -1)
            b = matrix[i - 1][j];
           
           if(i - 1 >= 0 && j + 1 < cols && matrix[i - 1][j + 1] != -1)
            c = matrix[i - 1][j + 1];
           
           if(a == -1 && b == -1 && c == -1)
            matrix[i][j] = -1;
           
           else matrix[i][j] +=Math.max(a , Math.max(b , c));
            }
        }
        int ans=0;
   for(int i = 0 ;i < rows ; i++){
       for(int j = 0 ; j < cols ; j++){
          ans = Math.max(ans , matrix[i][j]);
       }
    
   }
        return ans;
    }
}