class Solution {

    public int minFallingPathSum(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < cols; k++) {
                    if (k == j) {
                        continue;
                    }
                    min = Math.min(min, matrix[i - 1][k]);
                }

                matrix[i][j] += min;
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < cols; i++) {
            ans = Math.min(ans, matrix[rows - 1][i]);
        }

        return ans;
    }
}
