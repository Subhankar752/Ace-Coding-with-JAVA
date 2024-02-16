class Solution {
    public int[][] modifiedMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int[] max = new int[cols];
        
        for (int i = 0 ; i < rows ; i++) {
            for (int j = 0 ; j < cols ; j++) {
                max[j] = Math.max(max[j], matrix[i][j]);
            }
        }
        
        for (int i = 0 ; i < rows ; i++) { 
            for (int j = 0 ; j < cols ; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = max[j];
                }
            }
        }
        
        return matrix;
    }
}