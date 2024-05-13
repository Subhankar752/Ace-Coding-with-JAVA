class Solution {

    public int maxScore(List<List<Integer>> grid) {
        int m = grid.size(), n = grid.get(0).size();
        int ans[][] = new int[m][n];
        ans[m - 1][n - 1] = grid.get(m - 1).get(n - 1);
        
        for (int i = n - 2; i >= 0; i--) {
            ans[m - 1][i] = Math.max(ans[m - 1][i + 1], grid.get(m - 1).get(i));
        }
        for (int i = m - 2; i >= 0; i--) {
            ans[i][n - 1] = Math.max(ans[i + 1][n - 1], grid.get(i).get(n - 1));
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                ans[i][j] = Math.max(grid.get(i).get(j), Math.max(ans[i + 1][j], ans[i][j + 1]));
            }
        }
        
        int count = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i + 1 < m) {
                    count = Math.max(count, ans[i + 1][j] - grid.get(i).get(j));
                }
                if (j + 1 < n) {
                    count = Math.max(count, ans[i][j + 1] - grid.get(i).get(j));
                }
            }
        }
        
        return count;
    }
}
