class Solution {

    public int[] countPoints(int[][] points, int[][] queries) {
        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int pointCount = 0;
            for (var point : points) {
                if (isInsideCircle(point, queries[i])) pointCount++;
            }
            result[i] = pointCount;
        }
        return result;
    }

    private boolean isInsideCircle(int[] point, int[] circle) {
        int x1 = point[0] - circle[0];
        int y1 = point[1] - circle[1];
        return x1 * x1 + y1 * y1 <= circle[2] * circle[2];
    }
}
