class Solution {
    public boolean checkXMatrix(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j < cols ; j++){
                if(i == j || i == rows - 1 - j){
                    if(grid[i][j] == 0)
                        return false;
                }
                else{
                    if(grid[i][j] != 0)
                        return false;
                }
            }
        }
        return true;
    }
}