class Solution {
    Long[][] dp;
    
    public long maximumTotalCost(int[] nums) {
        dp = new Long[nums.length][2];
        
        return solve(0, nums, 0);
    }
    
    public long solve(int idx, int[] nums, int neg) {
        if (idx == nums.length) {
            return 0;
        }
        
        if (dp[idx][neg] != null) {
            return dp[idx][neg];
        }
        
        //current subarray
        int val = nums[idx];
        if (neg == 1) {
            val = -val;
        }
        long op1 = val + solve(idx + 1, nums, 1 - neg);
        
        //next subarray
        long op2 = nums[idx] + solve(idx + 1, nums, neg);
        
        return dp[idx][neg] = Math.max(op1, op2);
    }
}