class Solution {

    public class Pair {
        int row;
        int col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    int bfs[][] = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    public int maxDistance(int[][] grid) {
        Queue<Pair> q = new LinkedList<Pair>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 1) {
                    q.add(new Pair(i, j));
                }
            }
        }

        if (q.size() == grid.length * grid.length) {
            return -1;
        }

        int coumt = 0;
        int level = -1;
        while (!q.isEmpty()) {
            int size = q.size();
            level++;
            while (size > 0) {
                Pair rem = q.poll();

                for (int i = 0; i < 4; i++) {
                    int newrow = rem.row + bfs[i][0];
                    int newcol = rem.col + bfs[i][1];

                    if (newrow >= 0 && newrow < grid.length && newcol >= 0 && newcol < grid.length && grid[newrow][newcol] == 0) {
                        grid[newrow][newcol] = 1;
                        q.add(new Pair(newrow, newcol));
                    }
                }

                size--;
            }
        }

        return level;
    }
}
