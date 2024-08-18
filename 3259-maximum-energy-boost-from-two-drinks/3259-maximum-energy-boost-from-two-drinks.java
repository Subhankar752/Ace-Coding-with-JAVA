class Solution {
    int n;
    int[] a;
    int[] b;
    Long[][] dp;

    public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
        a = energyDrinkA;
        b = energyDrinkB;
        n = energyDrinkA.length;
        dp = new Long[n + 1][2];

        return Math.max(solve(0, 0), solve(0, 1));
    }

    public long solve(int i, int turn) {
        if (i >= n) {
            return 0;
        }
        
        if (dp[i][turn] != null) {
            return dp[i][turn];
        }

        long op1 = 0;
        long op2 = 0;
        if (turn == 1) {
            op1 = a[i] + solve(i + 1, turn);
            op2 = a[i] + solve(i + 2, 1 - turn);
        } else {
            op1 = b[i] + solve(i + 1, turn);
            op2 = b[i] + solve(i + 2, 1 - turn);
        }

        return dp[i][turn] = Math.max(op1, op2);
    }
}
