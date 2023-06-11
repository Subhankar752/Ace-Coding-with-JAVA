class Solution {

    public int sumDistance(int[] nums, String s, int d) {
        final int mod = 1_000_000_007;
        for (int i = 0; i < nums.length; i++) {
            nums[i] += d * (s.charAt(i) == 'R' ? 1 : -1);
        }

        Arrays.sort(nums);
        long sum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            long curr = i * (long) nums[i] - (n - 1 - i) * (long) nums[i];
            sum += curr;
            sum %= mod;
        }

        return (int) sum;
    }
}
