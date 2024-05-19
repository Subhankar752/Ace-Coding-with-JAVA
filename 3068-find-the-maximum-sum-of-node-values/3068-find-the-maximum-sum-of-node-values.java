class Solution {

    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long ans = 0;
        int min = Integer.MAX_VALUE;
        int count = 0;

        for (int i : nums) {
            if ((i ^ k) > i) {
                ans += i ^ k;
                count++;
                min = Math.min(min, (i ^ k) - i);
            } else {
                ans += i;
                min = Math.min(min, i - (i ^ k));
            }
        }

        if (count % 2 == 1) {
            ans -= min;
        }

        return ans;
    }
}
