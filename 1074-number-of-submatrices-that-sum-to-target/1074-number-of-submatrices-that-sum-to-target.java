class Solution {

    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int ans = 0;

        int[][] a = new int[rows][cols];
        a[0][0] = matrix[0][0];

        //1st column
        for (int i = 1; i < rows; i++) {
            a[i][0] = matrix[i][0] + a[i - 1][0];
        }

        //1st row
        for (int i = 1; i < cols; i++) {
            a[0][i] = matrix[0][i] + a[0][i - 1];
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                a[i][j] = matrix[i][j] + a[i - 1][j] + a[i][j - 1] - a[i - 1][j - 1];
            }
        }

        // for(int i = 0 ; i < rows ; i++) {
        //     for(int j = 0 ; j < cols ; j++) {
        //         System.out.print(a[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int k = i; k < rows; k++) {
                    for (int l = j; l < cols; l++) {
                        int x1 = i;
                        int y1 = j;
                        int x2 = k;
                        int y2 = l;

                        int f1 = 0;
                        int f2 = 0;
                        int f3 = 0;
                        int f4 = 0;

                        f1 = a[x2][y2];

                        if (x1 - 1 >= 0 && y1 - 1 >= 0) {
                            f2 = a[x1 - 1][y1 - 1];
                        }

                        if (y1 - 1 >= 0) {
                            f3 = a[x2][y1 - 1];
                        }

                        if (x1 - 1 >= 0) {
                            f4 = a[x1 - 1][y2];
                        }

                        int sum = f1 + f2 - f3 - f4;

                        if (sum == target) {
                            ans++;
                        }
                    }
                }
            }
        }

        return ans;
    }
}
