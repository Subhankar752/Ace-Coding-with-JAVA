class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] p = new int[n];
        
        for (int i = 1; i < n; i++)
        {
            p[i] = p[i - 1] + ((nums[i] == (nums[i - 1] + 1)) ? 1 : 0);
        }
        System.out.println(Arrays.toString(p));

        int[] ans = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++)  
        {
            if (p[i + k - 1] == (p[i] + k - 1))
            {
                ans[i] = (nums[i + k - 1]);
            }
            else
            {
                ans[i] = -1;
            }
        }
        
        return ans;
    }
}