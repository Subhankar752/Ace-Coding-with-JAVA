class Solution {
    public long putMarbles(int[] A, int k) {
        int n = A.length - 1;
        long B[] = new long[n], res = 0;
        for (int i = 0; i < B.length; i++) {
            B[i] = A[i] + A[i + 1];
        }
        Arrays.sort(B);
        for (int i = 0; i < k - 1; i++) {
            res += B[n - 1 - i] - B[i];
        }
        return res;
    }
}