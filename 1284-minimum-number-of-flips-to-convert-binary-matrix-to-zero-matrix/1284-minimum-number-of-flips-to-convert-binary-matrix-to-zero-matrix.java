class Solution {

    public int minFlips(int[][] mat) {
        Config init = new Config(mat, 0);
        if (init.isDone()) {
            return init.step;
        }

        Set<String> visited = new HashSet<>();
        visited.add(init.toString());

        Queue<Config> q = new LinkedList<>();
        q.add(init);
        while (!q.isEmpty()) {
            Config c = q.poll();
            for (Config next : c.getNeighbours()) {
                String nextStr = next.toString();
                if (!visited.contains(nextStr)) {
                    if (next.isDone()) return next.step;
                    visited.add(nextStr);
                    q.add(next);
                }
            }
        }
        return -1;
    }

    class Config {
        int[][] mat;
        int rows;
        int cols;
        int step;

        Config(int[][] mat, int step) {
            this.mat = mat;
            rows = mat.length;
            cols = mat[0].length;
            this.step = step;
        }

        private boolean isDone() {
            for (int i = 0; i < mat.length; i++) {
                for (int val : mat[i]) if (val != 0) return false;
            }
            return true;
        }

        public List<Config> getNeighbours() {
            List<Config> neighbours = new ArrayList<>();
            for (int i = 0; i < rows; i++) for (int j = 0; j < cols; j++) neighbours.add(flip(i, j));
            return neighbours;
        }

        private Config flip(int row, int col) {
            int[][] next = new int[rows][cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if ((i == row && j == col) || (i == row && j == col + 1) || (i == row + 1 && j == col) || (i == row && j == col - 1) || (i == row - 1 && j == col)) next[i][j] =
                        1 - mat[i][j]; else next[i][j] = mat[i][j];
                }
            }

            return new Config(next, step + 1);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < rows; i++) {
                for (int num : mat[i]) sb.append(num);
            }
            return sb.toString();
        }
    }
}
