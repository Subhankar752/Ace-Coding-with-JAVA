class Solution {
    Boolean[] dp;
    public boolean validPartition(int[] nums) {
        dp = new Boolean[nums.length + 1];
        return solve(nums , 0);
    }
    public boolean solve(int[] nums , int i){
        if(i >= nums.length)
            return true;
        if(dp[i] != null){
            return dp[i];
        }
        if(i <= nums.length - 3 && nums[i] == nums[i + 1] && nums[i + 1] == nums[i + 2]){
            return dp[i] = solve(nums , i + 2) | solve(nums , i + 3);
        }
        else if(i <= nums.length - 2 && nums[i] == nums[i + 1]){
            return dp[i] = solve(nums , i + 2);
        }
        else if(i <= nums.length - 3 && nums[i] + 1 == nums[i + 1] && nums[i + 1] + 1 == nums[i + 2]){
            return dp[i] = solve(nums , i + 3);
        }
        else
            return false;
    }
}