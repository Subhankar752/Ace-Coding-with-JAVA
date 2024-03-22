class Solution {

    public int minAbsDifference(int[] nums, int goal) {
        TreeSet<Integer> first = new TreeSet<>();
        TreeSet<Integer> second = new TreeSet<>();
        int n = nums.length;

        solve(0, n / 2, first, 0, nums);
        solve(n / 2, n, second, 0, nums);

        int ans = Integer.MAX_VALUE;

        for (int i : second) {
            int leftOver = goal - i;

            Integer floor = first.floor(leftOver);
            if (floor != null) {
                ans = Math.min(ans, leftOver - floor);
            }

            Integer ceiling = first.ceiling(leftOver);
            if (ceiling != null) {
                ans = Math.min(ans, ceiling - leftOver);
            }

            if (ans == 0) {
                return 0;
            }
        }

        return ans;
    }

    public void solve(int i, int len, TreeSet<Integer> list, int sum, int[] nums) {
        if (i == len) {
            list.add(sum);
            return;
        }

        solve(i + 1, len, list, sum, nums);
        solve(i + 1, len, list, sum + nums[i], nums);
    }
}
