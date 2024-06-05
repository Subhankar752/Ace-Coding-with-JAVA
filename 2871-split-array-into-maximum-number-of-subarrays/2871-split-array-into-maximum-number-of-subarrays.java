class Solution {
    public int maxSubarrays(int[] nums) {
        int ans = 0;
        int and = -1;
        
        for(int i : nums) {
            and &= i;
            if(and == 0) {
                ans++;
                and = -1;
            }
        }
        
        return Math.max(1, ans);
    }
}