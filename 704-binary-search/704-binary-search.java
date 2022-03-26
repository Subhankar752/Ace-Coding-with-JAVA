class Solution {
    public int search(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while(i <= j){
            int mid = i + (j - i)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] > target)
                j = mid - 1;
            else
                i = mid + 1;
        }
        return -1;
//         int low = 0;
//         int high = nums.length - 1;
        
//         while(low <= high){
//             int mid = (low + high) / 2;
//             if(nums[mid] == target) return mid;
            
//             else if(target > nums[mid]) low = mid + 1;
//             else high = mid - 1;
//         }
//         return -1;
    }
}