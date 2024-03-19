class Solution {

    public int findMinArrowShots(int[][] points) {
        int ans = 0;

        Arrays.sort(points, (a, b) -> a[1] - b[1]);
        int i = 0;
        int n = points.length;

        while (i < n) {
            ans++;

            int[] point = points[i];
            int y = point[1];
            i++;

            while (i < n && y >= points[i][0] && y <= points[i][1]) {
                i++;
            }
        }

        return ans;
    }
}
