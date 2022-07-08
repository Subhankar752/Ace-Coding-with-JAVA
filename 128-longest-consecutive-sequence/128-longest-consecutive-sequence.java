class Solution {
    public int longestConsecutive(int[] nums) {
        int c = 1;
        int ans = 0;
        Arrays.sort(nums);
        int n = nums.length;
        if(n == 0)
            return 0;
        for(int i = 1 ; i < n ; i++){
            if(nums[i] == nums[i - 1])
                continue;
            if(nums[i] == nums[i - 1] + 1){
                c++;
            }
            else{
                ans = Math.max(ans , c);
                c = 1;
            }
        }
        ans = Math.max(c , ans);
        return ans;
    }
}