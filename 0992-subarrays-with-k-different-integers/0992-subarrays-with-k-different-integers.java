class Solution {

    public int subarraysWithKDistinct(int[] nums, int k) {
        return subarraysWithKSize(nums, k) - subarraysWithKSize(nums, k - 1);
    }

    public int subarraysWithKSize(int[] nums, int k) {
        HashMap<Integer, Integer> hs = new HashMap<>();
        int count = 0;
        int i = 0;
        int j = 0;
        while (j < nums.length) {
            hs.put(nums[j], hs.getOrDefault(nums[j], 0) + 1);

            while (hs.size() == k + 1) {
                hs.put(nums[i], hs.get(nums[i]) - 1);
                if (hs.get(nums[i]) == 0) hs.remove(nums[i]);
                i++;
            }

            count += j - i + 1;
            j++;
        }

        return count;
    }
}
