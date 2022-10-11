class Solution {
    public boolean increasingTriplet(int[] nums) {
        int a = nums[0];
        int b = Integer.MAX_VALUE;
        
        for(int  i = 1 ; i < nums.length ; i++){

            if(nums[i] > b)
                return true;
            else if (nums[i] > a)
                b = nums[i];
            else
                a = nums[i];
        }

        return false;
    }
}