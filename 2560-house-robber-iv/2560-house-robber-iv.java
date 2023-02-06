class Solution {
    public int minCapability(int[] nums, int k) {
        
        int n = nums.length;
        int left = 1;
        int right = (int) 1e9;
        int ans = Integer.MAX_VALUE;
        
        while (left <= right) {
            
            int mid = left + (right - left) / 2;
            
            if(helper(nums , k , mid)){
                ans = Math.min(ans , mid);
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        
        return ans;
    }

    private static boolean helper(int[] nums, int k, int cur) {
        int i = 0;
        int n = nums.length;
        
        while (i < n) {
            if(nums[i] <= cur) {
                k--;
                i += 2;
            } 
            else {
                i++;
            }

            if(k == 0){
                return true;
            }
        }
        
        return k == 0;
    }
}