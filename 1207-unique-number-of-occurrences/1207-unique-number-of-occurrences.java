class Solution {

    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : arr) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        HashSet<Integer> hs = new HashSet<>();
        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            hs.add(m.getValue());
        }

        return hs.size() == map.size();
    }
}
