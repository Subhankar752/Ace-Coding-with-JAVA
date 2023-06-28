class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int left = 0;
        TreeSet<Integer> set = new TreeSet<>((a, b) -> nums[a] == nums[b] ? a - b : nums[a] - nums[b]);
        set.add(0);
        int res = 1;
        for (int right = 1; right < nums.length; right++) {
            set.add(right);
            while (nums[set.last()] - nums[set.first()] > limit) {
                set.remove(left++);
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}