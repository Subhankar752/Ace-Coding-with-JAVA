class Solution {

    public String optimalDivision(int[] nums) {
        String ans = Integer.toString(nums[0]);
        
        if (nums.length == 1) {
            return ans;
        }
        
        if (nums.length == 2) {
            return ans + "/" + Integer.toString(nums[1]);
        }
        
        ans += "/(" + Integer.toString(nums[1]);
        
        for (int i = 2; i < nums.length; i++) {
            ans += "/" + Integer.toString(nums[i]);
        }
        
        ans += ")";
        return ans;
    }
}
