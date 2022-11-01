class Solution {
    public int[] findBall(int[][] grid) {
        int[] result = new int[grid[0].length];
        
        for(int i = 0; i < grid[0].length; i++) {
            int x = 0;
            int y = i;
            while (x < grid.length) {
    
                if (grid[x][y] == 1) {
                    // go right
                    if (y + 1 > grid[0].length - 1 || grid[x][y + 1] == -1) {
                        break;
                    }
                    
                    x++;
                    y++;
                    
                } else {
                // go left
                    if (y - 1 < 0 || grid[x][y - 1] == 1) {
                        break;
                    }
                    x++;
                    y--;
                } 
            }
            
            // check if I am below the last row of the matrix.  If so I made it out.
            if (x == grid.length && y >= 0 && y <= grid[0].length -1) {
                result[i] = y;
            } else {
                result[i] = -1;
            }
        }
        
        return result;
    }
}