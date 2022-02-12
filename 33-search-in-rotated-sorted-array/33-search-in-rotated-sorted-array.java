class Solution {
    public int search(int[] nums, int target) {
        int l=0,r= nums.length-1, mid =0;
    while(l <= r){
        mid = (l+r)/2;
        if(nums[mid] == target) return mid;
        
        // check which part is sorted
        if(nums[l] <= nums[mid]){
            if(target >= nums[l]&& target < nums[mid]){
                r = mid-1;
            }else{
                l= mid+1;
            }
        }else {
            if(target >= nums[mid] && target<= nums[r]){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
    }
    
    return -1;
    }
}