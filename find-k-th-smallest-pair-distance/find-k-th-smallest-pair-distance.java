class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        
        int left = 0;
        int right = 1000000;
        
        while(left < right){
            int mid = left + (right - left)/2;
            if(at_least_k(nums, k, mid)){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        
        return left;
    }
    
    public boolean at_least_k(int[] nums, int k, int target_dist){
        
        int count = 0;
        
        int fast_p = 0;
        int slow_p = 0;
        
        while(fast_p < nums.length || slow_p < nums.length){
            while(fast_p < nums.length && nums[fast_p] - nums[slow_p] <= target_dist){
                fast_p ++;
            }
            count += fast_p - slow_p - 1;
            slow_p ++;
        }
        
        return count >= k;
    }
}