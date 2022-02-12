class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int s = 0;
        int e = n - 1;
        int ans = -1;
        while(s <= e){
            int mid = s + (e - s)/2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] > target){
                e = mid - 1;
            }
            else{
                s = mid + 1;
            }
        }
        if(ans != -1)
            return ans;
        for(int i = 0 ; i < n ; i++){
            if(target < nums[i])
                return i;
        }
        return n;
    }
}