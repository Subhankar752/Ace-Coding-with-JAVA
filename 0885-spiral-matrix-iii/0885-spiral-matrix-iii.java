public class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int i = rStart, j = cStart;
        int diri = 0, dirj = 1; 
        int twice = 2;
        int[][] res = new int[rows * cols][2]; 
        int moves = 1;
        int nextMoves = 2;
        int index = 0; 

        while (index < rows * cols) {
            if (i >= 0 && i < rows && j >= 0 && j < cols) {
                res[index++] = new int[]{i, j};
            }

            i += diri;
            j += dirj;
            moves -= 1;

            if (moves == 0) {
                int temp = diri;
                diri = dirj;
                dirj = -temp; 
                twice -= 1;

                if (twice == 0) {
                    twice = 2;
                    moves = nextMoves;
                    nextMoves += 1;
                } else {
                    moves = nextMoves - 1;
                }
            }
        }
        return res;
    }
}
