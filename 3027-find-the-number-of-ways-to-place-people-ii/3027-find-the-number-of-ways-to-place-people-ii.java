class Solution {

    public int numberOfPairs(int[][] points) {
        Arrays.sort(points, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int ans = 0;
        int n = points.length;

        for (int i = 0; i < n; i++) {
            
            int max = Integer.MIN_VALUE;
            
            for (int j = i + 1; j < n; j++) {
                if (points[i][1] >= points[j][1] && max < points[j][1]) {
                    ans++;
                    max = points[j][1];
                }
            }
        }

        return ans;
    }
}
