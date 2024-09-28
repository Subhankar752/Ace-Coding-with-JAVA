class Solution {

    private long helper(int[] a, int[] b, int i1, int i2, long[][] memo) {
        if (i1 == a.length) return 0;
        if (i2 >= b.length) return (long) -1e9;

        if (memo[i1][i2] != -1) {
            return memo[i1][i2];
        }

        long take = (long) a[i1] * b[i2] + helper(a, b, i1 + 1, i2 + 1, memo);
        long notTake = helper(a, b, i1, i2 + 1, memo);

        return memo[i1][i2] = Math.max(take, notTake);
    }

    public long maxScore(int[] a, int[] b) {
        long[][] memo = new long[4][b.length];
        if (a.length == b.length) {
            long ans = 0;
            for(int i = 0 ; i < 4 ; i++){
                ans += ((long) a[i] * (long) b[i]);
            }
            return ans;
        }
        for (int i = 0; i < 4; i++) {
            Arrays.fill(memo[i], -1);
        }
        return helper(a, b, 0, 0, memo);
    }
}
