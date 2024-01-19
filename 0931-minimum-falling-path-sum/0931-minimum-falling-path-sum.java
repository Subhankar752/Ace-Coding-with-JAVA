class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int val1 = matrix[i - 1][j];
                int val2 = Integer.MAX_VALUE;
                int val3 = Integer.MAX_VALUE;
                
                if (j - 1 >= 0) {
                    val2 = matrix[i - 1][j - 1];
                }   
                if (j + 1 < cols) {
                    val3 = matrix[i - 1][j + 1];
                }
                
                
                matrix[i][j] += Math.min(Math.min(val1, val2), val3);
            }
        }
        
        int ans = Integer.MAX_VALUE;
        for (int i = 0 ; i < cols; i++) {
            ans = Math.min(ans, matrix[rows - 1][i]);
        }
        
        return ans;
    }
}