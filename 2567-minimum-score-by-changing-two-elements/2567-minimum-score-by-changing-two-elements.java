class Solution {
    public int minimizeSum(int[] A) {
        int n = A.length;
        Arrays.sort(A);
        return Math.min(Math.min(A[n - 1] - A[2], A[n - 3] - A[0]), A[n - 2] - A[1]);
    }
}