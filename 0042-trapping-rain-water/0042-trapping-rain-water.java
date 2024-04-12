class Solution {

    public int trap(int[] height) {
        int n = height.length;

        int[] L = new int[n];
        int[] R = new int[n];

        L[0] = height[0];
        for (int i = 1; i < n; i++) {
            L[i] = Math.max(height[i], L[i - 1]);
        }

        R[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            R[i] = Math.max(height[i], R[i + 1]);
        }

        int total = 0;
        for (int i = 0; i < n; i++) {
            total += (Math.min(L[i], R[i]) - height[i]);
        }

        return total;
    }
}
