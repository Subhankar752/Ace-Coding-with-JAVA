class Solution {
    int n;
    int memo[];

    public int jump(int[] nums) {
        n = nums.length;
        memo = new int[10001];
       
        Arrays.fill(memo, -1);
        
        return solve(nums, 0);
    }

    public int solve(int[] nums, int indx) {
        if (indx >= n - 1) return 0;
        
        if (memo[indx] != -1) return memo[indx];
        
        int minStep = Integer.MAX_VALUE - 1;
        
        for (int i = indx + 1; i <= indx + nums[indx]; i++) {
            minStep = Math.min(minStep, 1 + solve(nums, i));
        }
        
        return memo[indx] = minStep;
    }
}
