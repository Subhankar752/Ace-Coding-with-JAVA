class Solution {
    boolean[][] vis;
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        vis = new boolean[rows][cols];
        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j < cols ; j++){
                    if(dfs(i , j , board , word , 0) == true)
                        return true;
            }
        }
        return false;
    }
    public boolean dfs(int i , int j , char[][] board , String word , int x){
        
        if(board[i][j] != word.charAt(x))
            return false;
        if(x == word.length() - 1)
            return true;
        vis[i][j] = true;
        int[] dx = {-1 , 0 , 1 , 0};
        int[] dy = {0 , 1 , 0 , -1};
        for(int k = 0 ; k < 4 ; k++){
            if(isValid(i + dx[k] , j + dy[k] , board) == true){
                if(dfs(i + dx[k] , j + dy[k] , board , word , x + 1) == true)
                    return true;
            }
        }
        vis[i][j] = false;
        
        return false;
    }
    public boolean isValid(int i , int j , char[][] board){
        int rows = board.length;
        int cols = board[0].length;
        if(i < 0 || j < 0 || i > rows - 1 || j > cols - 1)
            return false;
        if(vis[i][j] == true)
            return false;
        return true;
    }
}