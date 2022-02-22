// { Driver Code Starts
import java.util.*;
import java.math.*;

class Pair{
    
    int x,y;
    Pair(int x,int y)
    {
        this.x = x;
        this.y = y;
    }
}

class Gfg
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.next());
        while(t-- > 0)
        {
            int m = Integer.parseInt(sc.next());
            int n = Integer.parseInt(sc.next());
            char mat[][] = new char[m][n];
            for(int i=0;i<m;i++)
            {
                for(int j=0;j<n;j++)
                {
                    mat[i][j] = sc.next().charAt(0);
                }
            }
           
            Solution T = new Solution();
            int ans[][] = T.findDistance(mat, m, n);
            
            for(int i=0;i<m;i++)
            {
                for(int j=0;j<n;j++)
                {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


class Solution
{
    private static final int [][] direction = new int [][]
    {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public static int[][] findDistance(char mat[][], int m,int n)
    {
        // Your code goes here
        if (mat == null || m == 0) {
            return new int [][]{};
        }
        int [][] result = new int [m][n];
        for (int i = 0; i < m; i++)
            Arrays.fill(result[i], Integer.MAX_VALUE);
        bfs(mat, m, n, result);
        return result;
    }
    
    public static void bfs(char [][] mat, int m, int n, int [][] result) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 'B') {
                    queue.offer(new int []{i, j});
                    result[i][j] = 0;
                }
            }
        }
        if (queue.isEmpty()) {
            for (int i = 0; i < m; i++)
                Arrays.fill(result[i], -1);
            return;
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int [] current = queue.poll();
                mat[current[0]][current[1]] = 'P';
                for (int [] dir : direction) {
                    int x = current[0] + dir[0];
                    int y = current[1] + dir[1];
                    if (x < 0 || y < 0 || x >= m || y >= n || mat[x][y] != 'O') {
                        continue;
                    }
                    result[x][y] = Math.min(result[x][y], result[current[0]][current[1]] + 1);
                    queue.offer(new int []{x, y});
                }
            }
        }
        extraWorkForResult(result, m, n);
    }
    
    public static void extraWorkForResult(int [][] result, int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (result[i][j] == Integer.MAX_VALUE) {
                    result[i][j] = -1;
                }
            }
        }
    }
}