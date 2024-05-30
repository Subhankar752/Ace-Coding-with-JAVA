class Solution {

    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int n = nums.length;
        int[] pre = new int[n];
        pre[0] = nums[0];
        int ans = 0;

        for (int i = 1; i < n; i++) {
            pre[i] += pre[i - 1] + nums[i];
        }

        for (int i = 0; i + firstLen <= n; i++) {
            int val1 = 0;
            if (i == 0) {
                val1 = pre[i + firstLen - 1];
            } else {
                val1 = pre[i + firstLen - 1] - pre[i - 1];
            }

            int k1 = solve(pre, 0, i - 1, secondLen);
            int k2 = solve(pre, i + firstLen, n - 1, secondLen);
            int val2 = Math.max(k1, k2);
            ans = Math.max(ans, (val1 + val2));
        }

        return ans;
    }

    public int solve(int[] pre, int l, int r, int len) {
        if (l < 0 || r > pre.length - 1 || l > pre.length - 1 || r < 0) {
            return 0;
        }

        if (r - l + 1 < len) {
            return 0;
        }
        
        int ans = 0;
        for(int i = l ; i + len <= r + 1 ; i++) {
            int val = 0;
            
            if(i == 0) {
                val = pre[i + len - 1];
            }
            else {
                val = pre[i + len - 1] - pre[i - 1];
            }
            
            ans = Math.max(ans, val);
        }
        
        return ans;
    }
}
