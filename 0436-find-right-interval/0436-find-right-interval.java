class Solution {

    public int[] findRightInterval(int[][] intervals) {
        int[] ansarr = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            int ans = search(intervals[i][1], intervals);
            ansarr[i] = ans;
        }
        return ansarr;
    }

    public int search(int n, int[][] intervals) {
        int ans = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] >= n && intervals[i][0] < min) {
                ans = i;
                min = intervals[i][0];
            }
        }
        return ans;
    }
}
