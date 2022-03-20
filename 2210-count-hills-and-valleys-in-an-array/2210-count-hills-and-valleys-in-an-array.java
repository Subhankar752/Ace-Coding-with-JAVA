class Solution {
    public int countHillValley(int[] nums) {
       int left = nums[0];
        int result = 0;

        for (int i = 1; i < nums.length - 1; i++) {
            if (isHill(left, nums[i], nums[i + 1]) || isValley(left, nums[i], nums[i + 1])) {
                result++;
                left = nums[i];
            }
        }
        return result;
    }

    private boolean isHill(int left, int value, int right) {
        return value > left && value > right;
    }

    private boolean isValley(int left, int value, int right) {
        return value < left && value < right;
    }
}