class Solution {

    class Pair {
        int idx1;
        int idx2;
        int val;

        Pair(int idx1, int idx2, int val) {
            this.idx1 = idx1;
            this.idx2 = idx2;
            this.val = val;
        }
    }

    public int kthSmallest(int[][] matrix, int k) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        pq.add(new Pair(0, 0, matrix[0][0]));

        int ans = 0;
        while (k-- > 0) {
            Pair p = pq.remove();
            ans = p.val;

            //next row
            if (p.idx1 == 0 && p.idx2 + 1 < cols) {
                pq.add(new Pair(p.idx1, p.idx2 + 1, matrix[p.idx1][p.idx2 + 1]));
            }

            //next column only if 1st
            if (p.idx1 + 1 < rows) {
                pq.add(new Pair(p.idx1 + 1, p.idx2, matrix[p.idx1 + 1][p.idx2]));
            }
        }

        return ans;
    }
}
