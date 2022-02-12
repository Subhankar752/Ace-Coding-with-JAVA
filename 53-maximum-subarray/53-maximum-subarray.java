class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int lc = nums[0];
        int gc = nums[0];
        for(int i = 1 ; i < n ; i++){
            lc = Math.max(nums[i] , lc + nums[i]);
            gc = Math.max(lc , gc);
        }
        return gc;
    }
}