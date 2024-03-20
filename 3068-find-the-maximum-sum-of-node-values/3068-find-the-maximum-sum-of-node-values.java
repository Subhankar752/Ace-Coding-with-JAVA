class Solution {

    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        int n = nums.length;
        int count = 0;
        int max = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        long ans = 0;
        
        for (int i = 0; i < n; i++) {
            if ((nums[i] ^ k) > nums[i]) {
                max = Math.min(max, (nums[i] ^ k) - nums[i]);
                ans += (nums[i] ^ k);
                count++;
            } else {
                min = Math.min(min, nums[i] - (nums[i] ^ k));
                ans += nums[i];
            }
        }
        
        if (count % 2 != 0) {
            ans -= Math.min(max, min);
        }
        
        return ans;
    }
}
