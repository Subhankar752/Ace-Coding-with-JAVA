class Solution {
    public int dominantIndex(int[] nums) {
        int max = Integer.MIN_VALUE;
        int idx = -1;
        
        for(int i  = 0 ; i < nums.length ; i++){
            if(max < nums[i]){
                max = nums[i];
                idx = i;
            }
        }
        
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] == max)
                continue;
            int val = nums[i] * 2;
            if(val > max)
                return -1;
        }
        return idx;
    }
}