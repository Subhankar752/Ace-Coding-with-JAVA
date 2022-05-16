class Solution {
    
    class Pair{
        int a;
        int b;
        Pair(int a , int b){
            this.a = a;
            this.b = b;
        }
    }
    
    int rows;
    int cols;
    int[][] dist;
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        dist = new int[rows][cols];
        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j < cols ; j++){
                dist[i][j] = 0;
            }
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0 , 0));
        boolean[][] vis = new boolean[rows][cols];
        if(grid[0][0] == 1)
            return -1;
        vis[0][0] = true;
        int[] dx = {-1 , -1 , -1 , 0 , 1 , 1 , 1 , 0};
        int[] dy = {-1 , 0 , 1 , 1 , 1 , 0 , -1 , -1};
        while(!q.isEmpty()){
            Pair p = q.remove();
            int a = p.a;
            int b = p.b;
            for(int i = 0 ; i < 8 ; i++){
                if(isValid(a + dx[i] , b + dy[i] , grid , vis) == true){
                    q.add(new Pair(a + dx[i] , b + dy[i]));
                    vis[a + dx[i]][b + dy[i]] = true;
                    dist[a + dx[i]][b + dy[i]] += dist[a][b] + 1;
                }
            }
        }
        if(vis[rows - 1][cols - 1])
            return dist[rows - 1][cols - 1] + 1;
        return -1;
    }
    public boolean isValid(int i , int j , int[][] grid , boolean[][] vis){
        if(i < 0 || j < 0 || i > rows - 1 || j > cols - 1)
            return false;
        if(vis[i][j] == true)
            return false;
        if(grid[i][j] == 1)
            return false;
        return true;
    }
}