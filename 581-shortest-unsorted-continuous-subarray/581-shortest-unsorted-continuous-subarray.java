class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int e = -1;
        int max = nums[0];
        for(int i = 1 ; i < n ; i++){
            if(nums[i] < max){
                e = i;
            }
            else{
                max = nums[i];
            }
        }

        int s = 0;
        int min = nums[n - 1];
        for(int i = n - 2 ; i >= 0 ; i--){
            if(nums[i] > min){
                s = i;
            }
            else{
                min = nums[i];
            }
        }
        return e - s + 1;
    }
}