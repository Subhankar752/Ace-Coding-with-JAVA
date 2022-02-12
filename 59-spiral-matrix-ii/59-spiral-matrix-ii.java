class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int k = 1;
        int i = 0;
        for (; i < n - 1 - i; i++) {
            for (int j = i; j < n - 1 - i; j++) {
                ans[i][j] = k++;
            }
            for (int j = i; j < n - 1 - i; j++) {
                ans[j][n - 1 - i] = k++;
            }
            for (int j = n - 1 - i; j > i; j--) {
                ans[n - 1 - i][j] = k++;
            }
            for (int j = n - i - 1; j > i; j--) {
                ans[j][i] = k++;
            }
        }
        if (i == n - 1 - i) {
            ans[i][i] = k;
        }
        return ans;
    }
}