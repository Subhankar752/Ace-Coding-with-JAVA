class Solution {

    public List<Integer> goodSubsetofBinaryMatrix(int[][] grid) {
        List<Integer> ans = new ArrayList<>();

        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                boolean flag = true;

                for (int k = 0; k < cols; k++) {
                    if (grid[i][k] + grid[j][k] > 1) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    ans.add(i);

                    if (i != j) ans.add(j);
                    return ans;
                }
            }
        }

        return ans;
    }
}
