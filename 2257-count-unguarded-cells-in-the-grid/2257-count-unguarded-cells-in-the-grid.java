class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
//         int[][] grid = new int[m][n];
//         for(int[] i : walls){
//             int u = i[0];
//             int v = i[1];
//             grid[u][v] = -2;
//         }
//         for(int[] i : guards){
//             int u = i[0];
//             int v = i[1];
//             grid[u][v] = -1;
            
//             int x = u - 1;
//             int y = v;
//             while(x >= 0){
//                 if(grid[x][y] == -2)
//                     break;
//                 grid[x][y] = -1;
//                 x--;
//             }
           
//             x = u + 1;
//             y = v;
//             while(x < m){
//                 if(grid[x][y] == -2)
//                     break;
//                 grid[x][y] = -1;
//                 x++;
//             }
            
//             x = u;
//             y = v + 1;
//             while(y < n){
//                 if(grid[x][y] == -2)
//                     break;
//                 grid[x][y] = -1;
//                 y++;
//             }
            
//             x = u;
//             y = v - 1;
//             while(y >= 0){
//                 if(grid[x][y] == -2)
//                     break;
//                 grid[x][y] = -1;
//                 y--;
//             }
//         }
//         int ans = 0;
//         for(int i = 0 ; i < m ; i++){
//             for(int j = 0 ; j < n ; j++){
//                 if(grid[i][j] == 0)
//                     ans++;
//             }
//         }
//         return ans;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        char[][] grid= new char[m][n];
        int count = m*n - guards.length - walls.length;
        for(int[] wall : walls)
        {
            int x = wall[0], y = wall[1];
            grid[x][y] = 'W';
        }
        for(int[] guard : guards)
        {
            int x = guard[0], y = guard[1];
            grid[x][y] = 'G';
        }
        for(int[] point : guards)
        {
            for(int dir[] : dirs)
            {
                int x = point[0] + dir[0];
                int y = point[1] + dir[1];
                while(!(x < 0 || y < 0 || x >= m || y >= n || grid[x][y] == 'G' || grid[x][y] == 'W'))
                {
                    if(grid[x][y] != 'P')
                        count--;
                    grid[x][y] = 'P';
                    x += dir[0];
                    y += dir[1];
                }
            }
        }
        return count;
    }
}