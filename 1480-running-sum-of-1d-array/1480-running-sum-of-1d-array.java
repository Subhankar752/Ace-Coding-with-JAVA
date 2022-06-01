class Solution {
    public int[] runningSum(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int res = 0;
        for(int i = 0 ; i < n ; i++){
            res += nums[i];
            ans[i] = res;
        }
        return ans;
    }
}