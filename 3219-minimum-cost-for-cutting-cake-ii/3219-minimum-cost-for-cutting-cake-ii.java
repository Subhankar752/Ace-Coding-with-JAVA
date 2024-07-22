class Solution {

    public long minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        Arrays.sort(horizontalCut);
        Arrays.sort(verticalCut);

        int hor = 1, ver = 1;
        long total = 0;

        int i = horizontalCut.length - 1;
        int j = verticalCut.length - 1;
        
        while (i >= 0 && j >= 0) {
            if (horizontalCut[i] >= verticalCut[j]) {
                total += (long) horizontalCut[i] * ver;
                hor++;
                i--;
            } else {
                total += (long) verticalCut[j] * hor;
                ver++;
                j--;
            }
        }
        
        while (i >= 0) {
            total += (long) horizontalCut[i] * ver;
            hor++;
            i--;
        }

        while (j >= 0) {
            total += (long) verticalCut[j] * hor;
            ver++;
            j--;
        }
        
        return total;
    }
}
