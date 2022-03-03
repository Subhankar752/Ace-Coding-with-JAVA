// { Driver Code Starts
//Initial Template for Java

//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            String str[] = read.readLine().trim().split("\\s+");
            int r = Integer.parseInt(str[0]);
            int c = Integer.parseInt(str[1]);
            int matrix[][] = new int[r][c];
            
            for(int i = 0; i < r; i++)
            {
                int k = 0;
                str = read.readLine().trim().split("\\s+");
                for(int j = 0; j < c; j++){
                  matrix[i][j] = Integer.parseInt(str[k]);
                  k++;
                }
            }
            Solution obj = new Solution();
            int[] p = obj.endPoints(matrix,r,c);
            System.out.print("(" +  p[0]+ ", " +  p[1]+ ")" +"\n");
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int [] endPoints(int [][]arr, int m, int n){
        //code here
         int counter = 0;
       int[][] dir = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
       
       //traverse the arr
       int[] currCoord = new int[2];
       while(true){
           
           int yAxis = currCoord[0];
           int xAxis = currCoord[1];
           
           //check the current spot in the array
           if(arr[yAxis][xAxis] == 1){
               counter++;
           }
           
           //change value of array
           arr[yAxis][xAxis] = 0;
           
           int nyAxis = yAxis + dir[counter%4][0];
           int nxAxis = xAxis + dir[counter%4][1];
           //break condition
           if(nyAxis < 0 || nxAxis < 0 || nyAxis >= m|| nxAxis >= n){
               break;
           }
           
           //just traverse
           currCoord[0] = nyAxis;
           currCoord[1] = nxAxis;
       }
       
       return currCoord;
    }
}