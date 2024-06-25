class CountIntervals {
    TreeMap<Integer, Integer> m;
    int count = 0;

    public CountIntervals() {
        m = new TreeMap<>();
    }

    public void add(int left, int right) {
        int start = left, end = right;

        while (m.floorKey(end) != null && start <= m.get(m.floorKey(end)) && end >= m.floorKey(end)) {
            int l = m.floorKey(end);
            int r = m.get(l);
            count -= r - l + 1;
            m.remove(l);

            start = Math.min(start, l);
            end = Math.max(end, r);
        }

        count += end - start + 1;
        m.put(start, end);
    }

    public int count() {
        return count;
    }
}
/**
 * Your CountIntervals object will be instantiated and called as such:
 * CountIntervals obj = new CountIntervals();
 * obj.add(left,right);
 * int param_2 = obj.count();
 */
