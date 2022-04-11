// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

 // } Driver Code Ends
//User function Template for Java

class Solution{
    
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};
    
    private static boolean checkBounds(int i, int j, int r, int c){
        return (i>=0 && i<r && j>=0 && j<c);
    }
    
    private static boolean invalidState(int x, int y, int i, int j, int up, int down){
        if(x < i){
            return up == 0;
        }
        else if(x > i){
            return down == 0;
        }
        else{
            return false;
        }
    }
    
	public static int numberOfCells(int n, int m, int r, int c, int u, int d, char mat[][]){
		
		//Base case
		if(mat[r][c] == '#'){
		    return 0;
		}
		
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[]{r, c, u, d});
		
		boolean[][] vis = new boolean[n][m];
		vis[r][c] = true;
		int count = 0;
		
		while(!q.isEmpty()){
		    int size = q.size();
		    while(size-- > 0){
		        
		        int[] curr = q.poll();
		        int i = curr[0];
		        int j = curr[1];
		        //System.out.println(i + " " + j);
		        int up = curr[2];
		        int down = curr[3];
		        count++;
		        
		        for(int k=0;k<4;k++){
		            int x = i + dx[k];
		            int y = j + dy[k];
		            //System.out.println(x + " " + y);
		            
		            if(checkBounds(x, y, n, m) && !vis[x][y] && mat[x][y] == '.'){
		                if(invalidState(x, y, i, j, up, down)){
		                    continue;
		                }
		                else{
		                    vis[x][y] = true;
		                    if(x < i){
		                      q.offer(new int[]{x, y, up-1, down});  
		                    }
		                    else if(x > i){
		                      q.offer(new int[]{x, y, up, down-1});  
		                    }
		                    else{
		                        q.offer(new int[]{x, y, up, down});
		                    }    
		                }
		                
		            }
		            
		            
		        }
		        //System.out.println();
		        
		    }
		}
		return count;
	}

}


// { Driver Code Starts.

public class GFG {
	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0)
		{
		    int n = sc.nextInt();
		    int m = sc.nextInt();
		    int r = sc.nextInt();
		    int c = sc.nextInt();
		    int u = sc.nextInt();
		    int d = sc.nextInt();
		    
		    char mat[][] = new char[n][m];

            for(int i = 0; i < n; i++)
            {
                String s = sc.next();
                for(int j = 0; j < m; j++)
                {
                    mat[i][j] = s.charAt(j);
                }
            }
            
            Solution obj = new Solution();
            System.out.println(obj.numberOfCells(n, m, r, c, u, d, mat));
		    
		}
	}
}

  // } Driver Code Ends