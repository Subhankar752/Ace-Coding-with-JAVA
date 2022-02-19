// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}// } Driver Code Ends


class Solution {
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        // Code here
        int n=grid.length;
        int m=grid[0].length;
        int[][] vis=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                vis[i][j]=0;
            }
        }
        int c=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && vis[i][j]==0)
                {
                    c++;
                    dfs(i,j,n,m,grid,vis);
                }
            }
        }
        return c;
    }
     static void dfs(int x,int y,int n,int m,char[][] grid,int[][] vis){
        vis[x][y]=1;
        int[] dx={-1,-1,-1,0,1,1,1,0};
        int[] dy={-1,0,1,1,1,0,-1,-1};
        for(int i=0;i<8;i++){
            if(isValid(x+dx[i],y+dy[i],n,m,grid,vis)==true){
                dfs(x+dx[i],y+dy[i],n,m,grid,vis);
            }
        }
    }
    static boolean isValid(int x,int y,int n,int m,char[][] grid,int[][] vis){
        if(x<0 || y<0 || x>n-1 || y>m-1)
        return false;
        if(vis[x][y]==1)
        return false;
        if(grid[x][y]=='0')
        return false;
        return true;
    }
}