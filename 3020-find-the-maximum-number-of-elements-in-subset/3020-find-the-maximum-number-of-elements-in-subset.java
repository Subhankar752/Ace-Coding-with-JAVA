class Solution {
    int ans;

    public int maximumLength(int[] nums) {
        ans = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        for (int i : nums) {
            if (i != 1) {
                ans = Math.max(solve(nums, i, map, 1), ans);
            } else {
                int val = map.get(i);
                if (val % 2 == 0) {
                    val--;
                }

                ans = Math.max(ans, val);
            }
        }

        return ans;
    }

    public int solve(int[] a, int x, Map<Integer, Integer> map, int len) {
        if (map.get(x) == 1) {
            return len;
        } else {
            if (map.containsKey(x * x)) {
                return solve(a, x * x, map, len + 2);
            } else {
                return len;
            }
        }
    }
}
