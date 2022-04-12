class Solution {
    public void gameOfLife(int[][] board) {
        
        int[][] directions = { {0,1}, {0,-1}, {1,0}, {1,-1}, {1,1}, {-1,0}, {-1,-1}, {-1,1}};
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                // live is used to get count of adjacent live cells for board[i][j]
                int live = 0;
                for(int []dir : directions) {
                    // corner case? the next position is non existent, then do nothing but
                    // continue with the loop
                    if(dir[0] + i < 0 || dir[1] + j < 0 ||dir[0] + i > m || dir[1] + j >n)
                        continue;
                    
                    if(dir[0] + i < m && dir[1] + j < n && (board[dir[0] + i][dir[1] + j] == 1 || board[dir[0] + i] [dir[1] + j] == 2))
                        live++; // increment live count for adjacent live cells
                }
                // any dead cell with exactly 3 cells become live
                // mark that cell with number 3.
                if(board[i][j] == 0 && live == 3)
                    board[i][j] = 3;
                // any live cell with two or three live neighbours lives onto next generation
                // so let that be as it is
                // any live cell with more than 3 neighbours die due to overpopulation
                // any live cell with fewer than two live neighbours die as if caused by under population
                if(board[i][j] == 1 && (live > 3 || live < 2))
                    board[i][j] = 2;
                
            }
        }
        
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++) 
                // all cells marked with 3 will remain live while ones marked with 2 will be dead as the rule says
                board[i][j] = board[i][j] % 2;
    }
}