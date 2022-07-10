class Solution {
    public int wiggleMaxLength(int[] nums) {
        
       if (nums.length <= 1) return nums.length;
    
    int count = nums.length;
    Boolean positive = null;
    
    for (int i = 0; i < nums.length-1; i++){
        int temp = nums[i+1] - nums[i];
        if (temp == 0) count--;
        else if (positive == null) positive = temp > 0;
        else if ((temp > 0 && positive) || (temp < 0 && !positive))
            count--;
        else
            positive = !positive;
    }
    return count;
    }
}