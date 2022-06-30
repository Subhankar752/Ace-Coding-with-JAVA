class Solution {
    public int minMoves2(int[] nums) {
        int n = nums.length - 1;
        Arrays.sort(nums);
        int median = nums[n / 2];
        int ans = 0;
        
        for(int i = 0 ; i <= n ; i++){
            ans += Math.abs(median - nums[i]);
        }
        
        return ans;
    }
}