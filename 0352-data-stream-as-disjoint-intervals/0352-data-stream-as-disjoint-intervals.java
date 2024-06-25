class SummaryRanges {
    TreeMap<Integer, int[]> map;
    
    public SummaryRanges() {
        map = new TreeMap<>();
    }

    public void addNum(int val) {
        if (map.containsKey(val)) {
            return;
        }
        
        Integer lowerKey = map.lowerKey(val);
        Integer higherKey = map.higherKey(val);

        if (lowerKey != null && higherKey != null && val == map.get(lowerKey)[1] + 1 && val == map.get(higherKey)[0] - 1) {
            map.get(lowerKey)[1] = map.get(higherKey)[1];
            map.remove(higherKey);
        } else if (lowerKey != null && val <= map.get(lowerKey)[1] + 1) {
            map.get(lowerKey)[1] = Math.max(val, map.get(lowerKey)[1]);
        } else if (higherKey != null && val == map.get(higherKey)[0] - 1) {
            map.put(val, new int[] { val, map.get(higherKey)[1] });
            map.remove(higherKey);
        } else {
            map.put(val, new int[] { val, val });
        }
    }

    public int[][] getIntervals() {
        int[][] res = new int[map.size()][2];
        int i = 0;

        for (int[] a : map.values()) {
            res[i++] = a;
        }

        return res;
    }
}
/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */
