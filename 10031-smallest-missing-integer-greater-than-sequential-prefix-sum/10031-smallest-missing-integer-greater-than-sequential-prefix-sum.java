class Solution {

    public int missingInteger(int[] nums) {
        int i = 0;
        while (i < nums.length - 1 && nums[i] + 1 == nums[i + 1]) {
            i++;
        }

        int sum = 0;
        for (int j = 0; j <= i; j++) {
            sum += nums[j];
        }

        HashSet<Integer> hs = new HashSet<>();
        for (int j : nums) {
            hs.add(j);
        }

        while (hs.contains(sum)) {
            sum++;
        }

        return sum;
    }
}
