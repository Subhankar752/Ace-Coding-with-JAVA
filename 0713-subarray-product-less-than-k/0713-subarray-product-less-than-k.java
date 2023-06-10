class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int ans = 0;
        
        int i = 0;
        int n = nums.length;
        int p = 1;
        
        for(int j = 0 ; j < n ; j++){
            p *= nums[j];
            
            while(p >= k && i <= j){
                p /= nums[i];
                i++;
            }
            
            ans += (j - i + 1);
        }
        
        return ans;
    }
}