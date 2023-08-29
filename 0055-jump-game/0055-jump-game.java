class Solution {
   
    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length + 1];
        for(int i = 0 ; i < nums.length - 1 ; i++)
            dp[i] = -1;
        return solve(0, nums, dp);
    }
    
    public boolean solve(int index, int[] nums, int[] dp) {
//         if(i >= a.length - 1) {
//             return true;
//         }
        
//         if(dp[i])
//             return dp[i];
        
//         for(int k = 1 ; k <= a[i] ; k++) {
//             if(solve(i + k, a, dp)) {
//                 dp[i] = true;
//                 return true;
//             }
                
//         }
        
//         dp[i] = false;
//         return false;
        if (index >= nums.length-1) {
            return true;
        } 
        
        if (nums[index] == 0) {
            dp[index] = 0;
            return false;
        }
        
        if (dp[index] != -1){
            return dp[index] == 1;
        } 
        
        int jumps = nums[index];
        for (int i = 1; i <= jumps; i++) {
            if (solve(index+i, nums, dp)) {
                dp[index] = 1;
                return true;
            }
        }
        
        dp[index] = 0;
        return false;
    }
}