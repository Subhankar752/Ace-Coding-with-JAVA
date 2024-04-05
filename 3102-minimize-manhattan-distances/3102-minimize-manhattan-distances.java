class Solution {

    private int manhattan(int[][] points, int i, int j) {
        return Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
    }

    private int[] maxManhattanDistance(int[][] points, int remove) {
        int n = points.length;
        int maxSum = Integer.MIN_VALUE, minSum = Integer.MAX_VALUE, maxDiff = Integer.MIN_VALUE, minDiff = Integer.MAX_VALUE;
        int maxSumIndex = -1, minSumIndex = -1, maxDiffIndex = -1, minDiffIndex = -1;
        for (int i = 0; i < n; i++) {
            if (i != remove) {
                int sum = points[i][0] + points[i][1], diff = points[i][0] - points[i][1];
                if (sum > maxSum) {
                    maxSumIndex = i;
                    maxSum = sum;
                }
                if (sum < minSum) {
                    minSumIndex = i;
                    minSum = sum;
                }
                if (diff > maxDiff) {
                    maxDiffIndex = i;
                    maxDiff = diff;
                }
                if (diff < minDiff) {
                    minDiffIndex = i;
                    minDiff = diff;
                }
            }
        }
        int[] result = new int[2];
        return Math.max(maxSum - minSum, maxDiff - minDiff) == maxSum - minSum ? new int[] { maxSumIndex, minSumIndex } : new int[] { maxDiffIndex, minDiffIndex };
    }

    public int minimumDistance(int[][] points) {
        int[] m = maxManhattanDistance(points, -1);
        int[] m1 = maxManhattanDistance(points, m[0]); // remove mi
        int[] m2 = maxManhattanDistance(points, m[1]); // remove mj
        return Math.min(manhattan(points, m1[0], m1[1]), manhattan(points, m2[0], m2[1]));
    }
}
