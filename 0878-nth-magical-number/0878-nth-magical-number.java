class Solution {

    public int nthMagicalNumber(int N, int A, int B) {
        long a = A, b = B, tmp, l = 2, r = (long) 1e14, mod = (long) 1e9 + 7;
        while (b > 0) {
            tmp = a;
            a = b;
            b = tmp % b;
        }
        while (l < r) {
            long m = (l + r) / 2;
            if (m / A + m / B - m / (A * B / a) < N) l = m + 1; else r = m;
        }
        return (int) (l % mod);
    }
}
