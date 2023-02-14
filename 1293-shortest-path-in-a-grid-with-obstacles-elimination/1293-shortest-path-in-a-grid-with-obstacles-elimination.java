class Solution {
    public int shortestPath(int[][] grid, int k) {
        int rows = grid.length;
        int cols = grid[0].length;
        int ans = 0;
        
        int[][] lives = new int[rows][cols];
        
        for (int[] arr : lives) {
            Arrays.fill(arr, -1);
        }
        
        int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, k});
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                int row = queue.peek()[0];
                int col = queue.peek()[1];
                int currLives = queue.peek()[2];
                
                queue.poll();
                
                if (row == rows - 1 && col == cols - 1) {
                    return ans;
                }
                
                if (grid[row][col] == 1) {
                    currLives--;
                }
                
                for (int[] dir : dirs) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];
                    
                    if (newRow >= 0 && newCol >= 0 && newRow < rows && newCol < cols && lives[newRow][newCol] < currLives) {
                        queue.add(new int[]{newRow, newCol, currLives});
                        lives[newRow][newCol] = currLives;
                    }
                }
            }
            ans++;
        }
        return -1;
    }
}