class Solution {

    public int sumOfPower(int[] nums) {
        int n = nums.length;
    if (n == 0) return 0;
    Arrays.sort(nums);
    long preSum = 0, res = 0, mod = 1_000_000_000 + 7, add = 0;
    for (int i = 0; i < nums.length; i++) {
        add = (preSum + nums[i]) * nums[i] % mod * nums[i] % mod;
        res = (res + add) % mod;
        preSum = (preSum * 2 + nums[i]) % mod;
    }
    return (int) res;
    }
}