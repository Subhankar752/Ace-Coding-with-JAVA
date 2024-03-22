class Solution {

    public int minOperations(List<Integer> nums, int target) {
        long sum = 0;
        for (int i : nums) {
            sum += i;
        }

        if (sum < target) {
            return -1;
        }

        int ans = 0;
        Collections.sort(nums);
        
        while (target > 0) {
            int cur = nums.remove(nums.size() - 1);

            if (sum - cur >= target) {
                sum -= cur;
            } else if (cur <= target) {
                sum -= cur;
                target -= cur;
            } else {
                int val = cur / 2;
                nums.add(val);
                nums.add(val);
                ans++;
            }
        }

        return ans;
    }
}
