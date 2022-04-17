class Solution {
    boolean[][] vis;
    int rows;
    int cols;
    int fv;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int rows = image.length;
        int cols = image[0].length;
        boolean[][] vis = new boolean[rows][cols];
        this.vis = vis;
        this.rows = rows;
        this.cols = cols;
        int fv = image[sr][sc];
        this.fv = fv;
        dfs(sr , sc , newColor , image);
        return image;
    }
    public void dfs(int i , int j , int val , int[][] image){
        vis[i][j] = true;
        image[i][j] = val;
        int[] dx = {-1 , 0 , 1 , 0};
        int[] dy = {0 , 1 , 0 , -1};
        for(int k=0;k<4;k++){
            if(isValid(i+dx[k] , j+dy[k] , image) == true)
                dfs(i+dx[k] , j+dy[k] , val , image);
        }
    }
    public boolean isValid(int i , int j , int[][] image){
        if(i<0 || j<0 || i>rows-1 || j>cols-1)
            return false;
        if(image[i][j] != fv)
            return false;
        if(vis[i][j] == true)
            return false;
        return true;
    }
}