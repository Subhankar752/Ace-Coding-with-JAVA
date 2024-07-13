class Solution {

    public int[] smallestRange(List<List<Integer>> a) {
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o -> a.get(o[0]).get(o[1])));
        int max = Integer.MIN_VALUE, start = 0, end = Integer.MAX_VALUE;
        
        for (int i = 0; i < a.size(); i++) {
            q.offer(new int[] { i, 0 });
            max = Math.max(max, a.get(i).get(0));
        }
        
        while (q.size() == a.size()) {
            int e[] = q.poll(), row = e[0], col = e[1];
        
            if (end - start > max - a.get(row).get(col)) {
                start = a.get(row).get(col);
                end = max;
            }
            if (col + 1 < a.get(row).size()) {
                q.offer(new int[] { row, col + 1 });
                max = Math.max(max, a.get(row).get(col + 1));
            }
        }
        
        return new int[] { start, end };
    }
}
