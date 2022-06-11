class Solution {
    public long countSubarrays(int[] nums, long k) {
        long sum = 0, res = 0;
    for (int i = 0, j = 0; i < nums.length; ++i) {
        sum += nums[i];
        while (sum * (i - j + 1) >= k)
            sum -= nums[j++];
        res += i - j + 1;
    }
    return res;
    }
}