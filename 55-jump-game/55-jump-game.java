class Solution {
    public boolean canJump(int[] nums) {
        int i , m;
        m = nums[0];
        int n = nums.length;
        for(i = 0 ; i <= m ; i++){
            if(i + nums[i] > m)
                m = i + nums[i];
            if(m >= n - 1)
                return true;
        }
        return false;
    }
}