class Solution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] r = new int[rows];
        int[] c = new int[cols];
        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j < cols ; j++){
                if(matrix[i][j] == 0)
                {
                    r[i] = 1;
                    c[j] = 1;
                }
            }
        }
        
        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j < cols ; j++){
                if(r[i] == 0 && c[j] == 0)
                    continue;
                else
                    matrix[i][j] = 0;
            }
        }
    }
}