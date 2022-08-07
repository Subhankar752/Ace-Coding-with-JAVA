class Solution {
    public long minimumReplacement(int[] nums) {
        long ops = 0;
        int prev = Integer.MAX_VALUE; // Dummy value.
        for (int i = nums.length - 1; i >= 0; --i) {
            int cur = nums[i];
            if (cur > prev) {
                int times = (cur + prev - 1) / prev;
                prev = cur / times;
                ops += times - 1;
            }else {
                prev = cur;
            }
        }
        return ops;
    }
}