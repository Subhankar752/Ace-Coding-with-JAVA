class Solution {

    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        pq.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
           
            if (pq.peek()[1] <= intervals[i][0]) {
                pq.remove();
            }

            pq.add(intervals[i]);
        }

        return pq.size();
    }
}
