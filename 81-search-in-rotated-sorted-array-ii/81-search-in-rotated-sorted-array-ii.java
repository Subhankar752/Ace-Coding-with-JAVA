class Solution {
    public boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        
        while(low <= high){
            
            int mid = low + (high - low) / 2;
            
            if(nums[mid] == target) return true;
            
            if(nums[mid] > nums[low]){
                
                if(target < nums[mid] && target >= nums[low]) high = mid;
                
                else low = mid +1;
            }
            
            else if(nums[mid] < nums[low]){
                
                if(target > nums[mid] && target < nums[low]) low = mid + 1;
                
                else high = mid;
            }
            else low++;
        }
        return false;
    }
}