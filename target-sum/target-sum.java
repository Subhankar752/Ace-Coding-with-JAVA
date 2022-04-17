class Solution {
   public int findTargetSumWays(int[] nums, int target) {
        return totalWays(nums,0,target);
    }
    
    private int totalWays(int[] nums , int currentIndex , int target){
        
        // Base case
        if(currentIndex == nums.length && target==0)
            return 1;
        
        if(currentIndex == nums.length && target!=0)
            return 0;
        
        int posSign = totalWays(nums,currentIndex+1,target-nums[currentIndex]);
        int negSign = totalWays(nums,currentIndex+1,target+nums[currentIndex]);
        
        return posSign + negSign;
    }
}