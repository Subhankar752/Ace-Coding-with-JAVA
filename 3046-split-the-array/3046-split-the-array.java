class Solution {
    public boolean isPossibleToSplit(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            }
            else {
                map.put(i, 1);
            }
        }
        
        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            if (m.getValue() > 2) {
                return false;
            }
        }
        
        return true;
    }
}