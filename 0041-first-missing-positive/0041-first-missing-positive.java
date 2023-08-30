class Solution {

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        int ones = 0;
        for (int i : nums) {
            if (i == 1) {
                ones++;
                break;
            }
        }

        if (ones == 0) {
            return 1;
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > n || nums[i] <= 0) {
                nums[i] = 1;
            }
        }

        for (int i = 0; i < n; i++) {
            int cur = Math.abs(nums[i]);

            if (cur == n) {
                nums[0] = -Math.abs(nums[0]);
            } else {
                nums[cur] = -Math.abs(nums[cur]);
            }
        }

        for (int i : nums) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 1; i < n; i++) {
            if (nums[i] > 0) return i;
        }

        if (nums[0] > 0) return n;

        return n + 1;
    }
}
