class Solution {

    public int largestOverlap(int[][] img1, int[][] img2) {
        int ans = 0;
        for (int i = 0; i < img1.length; i++) {
            for (int j = 0; j < img1.length; j++) {
                ans = Math.max(ans, rightDownLeftUp(img1, img2, i, j));
                ans = Math.max(ans, rightDownLeftUp(img2, img1, i, j));

                ans = Math.max(ans, rightUpLeftDown(img1, img2, i, j));
                ans = Math.max(ans, rightUpLeftDown(img2, img1, i, j));
            }
        }
        return ans;
    }

    public static int rightDownLeftUp(int[][] a, int[][] b, int iShift, int jShift) {
        int count = 0;
        for (int i = iShift; i < a.length; i++) {
            for (int j = jShift; j < a.length; j++) {
                if (a[i][j] == 1 && b[i - iShift][j - jShift] == 1) count++;
            }
        }
        return count;
    }

    public static int rightUpLeftDown(int[][] a, int[][] b, int iShift, int jShift) {
        int count = 0;
        for (int i = iShift; i < a.length; i++) {
            for (int j = 0; j < a.length - jShift; j++) {
                if (a[i][j] == 1 && b[i - iShift][j + jShift] == 1) count++;
            }
        }
        return count;
    }
}
