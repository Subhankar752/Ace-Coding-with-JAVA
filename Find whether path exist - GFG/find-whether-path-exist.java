// { Driver Code Starts
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
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            boolean ans = obj.is_Possible(grid);
            if(ans)
                System.out.println("1");
            else 
                System.out.println("0");
        }
    }
}// } Driver Code Ends




class Solution
{
    class Pair{
        int a;
        int b;
        Pair(int a , int b){
            this.a = a;
            this.b = b;
        }
    }
    //Function to find whether a path exists from the source to destination.
    public boolean is_Possible(int[][] grid)
    {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        int srcX = 0;
        int srcY = 0;
        int destX = 0;
        int destY = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 1){
                    srcX = i;
                    srcY = j;
                }
                else if(grid[i][j] == 2){
                    destX = i;
                    destY = j;
                }
            }
        }
        Queue<Pair> q = new LinkedList<>();
        int[] dx = {-1 , 0 , 1 , 0};
        int[] dy = {0 , 1 , 0 , -1};
        q.add(new Pair(srcX , srcY));
        boolean[][] vis = new boolean[n][m];
        vis[srcX][srcY] = true;
        
        while(!q.isEmpty()){
            Pair p = q.remove();
            int u = p.a;
            int v = p.b;
            for(int i = 0 ; i < 4 ; i++){
                int x = u + dx[i];
                int y = v + dy[i];
                if(isValid(x , y , grid , vis , n , m))
                {
                    q.add(new Pair(x , y));
                    vis[x][y] = true;
                }
            }
        }
        return vis[destX][destY];
    }
    public boolean isValid(int i , int j , int[][] grid , boolean[][] vis , int n , int m){
        if(i < 0 || j < 0 || i > n - 1 || j > m - 1)
        return false;
        if(vis[i][j])
        return false;
        if(grid[i][j] == 0)
        return false;
        return true;
    }
}