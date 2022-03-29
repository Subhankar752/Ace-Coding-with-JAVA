class Solution {
    public int findDuplicate(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int j = Math.abs(nums[i]);
            if(nums[j]>=0)
                nums[j] = -nums[j];
            else
                return j;
        }
        return -1;
    }
}