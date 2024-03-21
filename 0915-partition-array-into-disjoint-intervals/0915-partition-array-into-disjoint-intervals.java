class Solution {

    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int[] max = new int[n];
        int[] min = new int[n];

        max[0] = nums[0];
        for (int i = 1; i < n; i++) {
            max[i] = Math.max(max[i - 1], nums[i]);
        }

        min[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            min[i] = Math.min(min[i + 1], nums[i]);
        }

        for (int i = 0; i < n - 1; i++) {
            if (max[i] <= min[i + 1]) {
                return i + 1;
            }
        }

        return 0;
    }
}
