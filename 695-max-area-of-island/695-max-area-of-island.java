class Solution {
    int[][] grid;
    boolean[][] vis;
    int count=0;
    int max=0;
    int n;
    int m;
    public int maxAreaOfIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        this.n=n;
        this.m=m;
        this.grid=grid;
        boolean[][] vis=new boolean[n][m];
        this.vis=vis;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1 && vis[i][j] == false){
                    dfs(i,j);
                    max=Math.max(max,count);
                    count=0;
                }
            }
        }
        return max;
    }
    public void dfs(int x,int y){
        vis[x][y]=true;
        count++;
        int[] dx={-1,0,1,0};
        int[] dy={0,1,0,-1};
        for(int i=0;i<4;i++){
            if(isValid(x+dx[i] , y+dy[i])==true){
                dfs(x+dx[i] , y+dy[i]);
            }
        }
    }
    public boolean isValid(int x,int y){
        if(x<0 || x>n-1 || y<0 || y>m-1)
            return false;
        if(vis[x][y] == true)
            return false;
        if(grid[x][y] == 0)
            return false;
        return true;
    }
}