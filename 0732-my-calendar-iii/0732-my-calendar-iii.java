class MyCalendarThree {
    TreeMap<Integer, Integer> map;

    public MyCalendarThree() {
        map = new TreeMap<>();
    }

    public int book(int startTime, int endTime) {
        if (map.containsKey(startTime)) {
            map.put(startTime, map.get(startTime) + 1);
        } else {
            map.put(startTime, 1);
        }

        if (map.containsKey(endTime)) {
            map.put(endTime, map.get(endTime) - 1);
        } else {
            map.put(endTime, -1);
        }

        int cur = 0;
        int max = 0;

        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            int val = m.getValue();
            cur += val;
            max = Math.max(max, cur);
        }

        return max;
    }
}
/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(startTime,endTime);
 */
