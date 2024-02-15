class Solution {

    public long largestPerimeter(int[] nums) {
        long ans = -1;
        long[] pre = new long[nums.length];
        
        Arrays.sort(nums);
        
        pre[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pre[i] = pre[i - 1] + nums[i];
        }

        for (int i = nums.length - 1; i >= 2; i--) {
            if (pre[i - 1] > nums[i]) {
                ans = nums[i] + pre[i - 1];
                break;
            }
        }

        return ans;
    }
}
