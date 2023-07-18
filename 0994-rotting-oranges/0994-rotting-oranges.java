class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        Queue<int[]> frontier = new LinkedList<>(); //contains rotten oranges
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int fresh = 0; //number of remaining fresh oranges
        int min = 0; //minutes elapsed
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                } else if (grid[i][j] == 2) {
                    visited[i][j] = true; //mark rotten as visited
                    frontier.offer(new int[]{i, j});
                } else {
                    visited[i][j] = true; //mark empty as visited
                }
            }
        }
        Queue<int[]> nextFrontier = new LinkedList<>();
        while (!frontier.isEmpty()) {
            int[] next = frontier.poll();
            int y = next[0], x = next[1];
            for (int[] dir : dirs) {
                int next_y = y + dir[0];
                int next_x = x + dir[1];
                if (next_y >= 0 && next_x >= 0 && next_y < grid.length && next_x < grid[0].length && !visited[next_y][next_x]) {
                    //has to be a fresh orange
                    visited[next_y][next_x] = true;
                    nextFrontier.offer(new int[]{next_y, next_x});
                    fresh--;
                }
            }
            if (frontier.isEmpty() &&  !nextFrontier.isEmpty()) {
                frontier = nextFrontier;
                min++;
                nextFrontier = new LinkedList<>();
            }
        }
        return fresh == 0 ? min : -1;
    }
}