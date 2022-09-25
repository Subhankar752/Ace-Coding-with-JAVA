class Solution {
    public int longestSubarray(int[] nums) {
        int ans = 1;
        
        int max = -1;
        for(int i : nums)
            max = Math.max(max , i);
        
        int i = 0;
        while(i < nums.length){
            int len = 0;
            
            while(i < nums.length && nums[i] == max){
                i++;
                len++;
            }
            
            i++;
            ans = Math.max(len , ans);
        }
        
        return ans;
    }
}