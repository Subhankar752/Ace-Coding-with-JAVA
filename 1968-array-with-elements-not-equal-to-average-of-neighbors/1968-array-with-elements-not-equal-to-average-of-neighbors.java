class Solution {

    public int[] rearrangeArray(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] ans = new int[n];
        int k = n - 1;
        for (int i = 0; i < n; i += 2) {
            ans[i] = nums[k];
            k--;
        }
        k = 0;
        for (int i = 1; i < n; i += 2) {
            ans[i] = nums[k];
            k++;
        }
        return ans;
    }
}
