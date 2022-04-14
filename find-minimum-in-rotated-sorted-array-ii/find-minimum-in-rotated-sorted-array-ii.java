class Solution {
    public int findMin(int[] nums) {
        int start = 0, end = nums.length - 1;
        for (int index = 0; index < nums.length; index++){
        if (nums[start] > nums[end]){
            start++;
        } else if (end > 0 && nums[end - 1] <= nums[end]){
            end--;
        } else{
            return nums[start];
        }
    }
    return nums[0];
    }
}