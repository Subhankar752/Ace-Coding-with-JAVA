class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int xr = 0;
        int m = nums.length;
        int n = nums.length - 2;

        // XOR all elements of the array
        for (int i = 0; i < m; i++) {
            xr = xr ^ nums[i];
        }

        // XOR all integers from 0 to n-1
        for (int i = 0; i < n; i++) {
            xr = xr ^ i;
        }

        // Find the rightmost set bit in the result
        int right = xr & ~(xr - 1);

        int t1 = 0;
        int t2 = 0;

        // Split the array into two groups and XOR elements
        for (int i = 0; i < m; i++) {
            if ((nums[i] & right) != 0) {
                t1 = t1 ^ nums[i];
            } else {
                t2 = t2 ^ nums[i];
            }
        }

        // XOR with numbers from 0 to n-1 to finalize the two missing numbers
        for (int i = 0; i < n; i++) {
            if ((i & right) != 0) {
                t1 = t1 ^ i;
            } else {
                t2 = t2 ^ i;
            }
        }

        return new int[] { t1, t2 };
    }
}
