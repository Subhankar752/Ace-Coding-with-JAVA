class Solution {

    public long matrixSumQueries(int n, int[][] queries) {
        long ans = 0;

        Map<Integer, Integer> rowIndex = new HashMap<>();
        Map<Integer, Integer> colIndex = new HashMap<>();

        long rowSum = 0;
        long colSum = 0;

        int r = queries.length;
        int c = queries[0].length;

        ArrayList<int[]> q = new ArrayList<>();

        for (int x = r - 1 ; x >= 0 ; x--) {
            int type = queries[x][0];
            int index = queries[x][1];
            int val = queries[x][2];

            if (type == 0) {
                if (rowIndex.containsKey(index)) {
                    // ans += (val * n) - (rowIndex.get(index) * n);
                    // rowSum += val - rowIndex.get(index);
                } else {
                    ans += val * (n - colSum);
                    rowSum++;
                }

                rowIndex.put(index, val);
            } else {
                if (colIndex.containsKey(index)) {
                    // ans += (val * n) - (colIndex.get(index) * n);
                    // colSum += val - colIndex.get(index);
                } else {
                    ans += val * (n - rowSum);
                    colSum++;
                }

                colIndex.put(index, val);
            }
        }

        return ans;
    }
}
