class Solution {
    class Pair {
        int a;
        int b;
        Pair (int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
    
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        Queue<Pair> q = new LinkedList<>();
        
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < m ; j++) {
                if(grid[i][j] == 2) {
                    q.add(new Pair(i, j));
                }
            }
        }
        
        q.add(new Pair(-1, -1));
        int ans = 0;
        while(!q.isEmpty()) {
            Pair p = q.remove();
            if(p.a == -1 && p.b == -1) {
                if(q.size() > 0) {
                    ans++;
                    q.add(new Pair(-1, -1));
                }
            }
            else{
                int x = p.a;
                int y = p.b;
                
                int[] dx = {1, -1, 0, 0};
                int[] dy = {0, 0, 1, -1};
                
                for(int k = 0 ; k < 4 ; k++) {
                    if(isValid(x + dx[k], y + dy[k], grid)) {
                        q.add(new Pair(x + dx[k], y + dy[k]));
                    }
                }
            }
        }
        
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < m ; j++) {
                if(grid[i][j] == 1)
                    return -1;
            }
        }
        
        return ans;
    }
    public boolean isValid(int i, int j, int[][] grid) {
        if(i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1)
            return false;
        if(grid[i][j] == 0 || grid[i][j] == 2)
            return false;
        
        grid[i][j] = 2;
        
        return true;
    }
}