class Solution {

    public long findKthSmallest(int[] coins, int k) {
        long ans = 0;
        long l = 0;
        long r = (long) 1e18;

        while (l <= r) {
            long m = l + (r - l) / 2;
            long count = solve(m, coins);
            if (count >= k) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return ans;
    }

    public long solve(long x, int[] a) {
        long ans = 0;
        int n = a.length;
        int allOnes = (1 << n) - 1;

        for (int i = 1; i <= allOnes; i++) {
            long lcm = 1;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    lcm = findLCM(lcm, a[j]);
                }
            }

            if (Integer.bitCount(i) % 2 == 0) {
                ans -= x / lcm;
            } else {
                ans += x / lcm;
            }
        }

        return ans;
    }

    public long findLCM(long a, long b) {
        return (a * b) / gcd(a, b);
    }

    public long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }
}
