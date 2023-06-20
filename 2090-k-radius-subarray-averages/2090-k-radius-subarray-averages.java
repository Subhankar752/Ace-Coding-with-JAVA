class Solution {

    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = -1;
        }

        int l = k;
        int r = n - k - 1;

        long[] pre = new long[n];
        long[] suff = new long[n];

        pre[0] = nums[0];
        for (int i = 1; i < n; i++) {
            pre[i] = nums[i] + pre[i - 1];
        }

        suff[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suff[i] = nums[i] + suff[i + 1];
        }
        
        long x = 0;
        long y = 0;
        
        for (int i = l; i <= r; i++) {
            long val = 0;
            if (i - k - 1 < 0) val = 0; else val = pre[i - k - 1];
            
            x = pre[i] - nums[i] - val;

            if (i + k + 1 > n - 1) val = 0; else val = suff[i + k + 1];
            y = suff[i] - nums[i] - val;

            ans[i] = (int) ((nums[i] + x + y) / (2 * k + 1));
        }

        return ans;
    }
}
