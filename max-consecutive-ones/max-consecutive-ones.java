class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int i = 0;
        int max = 0;
        for(int j = 0 ; j < n ; j++){
            if(nums[j] == 0){
                if(j < n-1){
                    i = j + 1;
                }
            }
            else{
                max = Math.max(max , j - i + 1);
            }
        }
        return max;
    }
} 