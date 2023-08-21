class Solution {

    public int longestEqualSubarray(List<Integer> nums, int k) {
        int n = nums.size();
        int i = 0;
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int j = 0; j < n; j++) {
            int cur = nums.get(j);
            if (map.containsKey(cur)) {
                map.put(cur, map.get(cur) + 1);
            } else {
                map.put(cur, 1);
            }

            max = Math.max(max, map.get(cur));
            int deleteRequired = j - i + 1 - max;

            if (deleteRequired > k) {
                int val = nums.get(i);
                map.put(val, map.get(val) - 1);
                i++;
            }
        }

        return max;
    }
}
