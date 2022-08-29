class Solution {
    public int numIslands(char[][] grid) {
        int ans = 0;
        
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] vis = new boolean[rows][cols];
        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j < cols ; j++){
                if(!vis[i][j] && grid[i][j] == '1'){
                    dfs(i , j , grid , vis);
                    ans++;
                }
            }
        }
        
        return ans;
    }
    
    public void dfs(int i , int j , char[][] grid , boolean[][] vis){
        vis[i][j] = true;
        
        int[] dx = {-1 , 0 , 1 , 0};
        int[] dy = {0 , 1 , 0 , -1};
        for(int k = 0 ; k < 4 ; k++){
            if(isValid(i + dx[k] , j + dy[k] , grid , vis) == true){
                dfs(i + dx[k] , j + dy[k] , grid , vis);
            }
        }
    }
    
    public boolean isValid(int i , int j , char[][] grid , boolean[][] vis){
        int rows = grid.length;
        int cols = grid[0].length;
        
        if(i < 0 || j < 0 || i > rows - 1 || j > cols - 1)
            return false;
        if(vis[i][j])
            return false;
        if(grid[i][j] == '0')
            return false;
        return true;
    }
}