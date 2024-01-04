class Solution {

    public int minOperations(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        int ans = 0;

        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            int value = m.getValue();
            
            if (value == 1) {
                return -1;
            }

            ans += Math.ceil((value * 1.0) / 3);
        }

        return ans;
    }
}
