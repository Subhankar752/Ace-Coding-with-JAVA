// { Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];
        
        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }
        
        return mat;
    }
    
    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
    
    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int[] a = IntArray.input(br, 2);
            
            
            int[] b = IntArray.input(br, 4);
            
            
            int[][] mat = IntMatrix.input(br, a[0], a[1]);
            
            Solution obj = new Solution();
            int res = obj.longestPath(mat,a[0],a[1],b[0],b[1],b[2],b[3]);
            
            System.out.println(res);
            
        }
    }
}
// } Driver Code Ends


class Solution {
    
    private final static int [][] direction = new int [][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public static int longestPath(int[][] mat , int n , int m , int xs , int ys , int xd , int yd) {
        // code here
        if (mat[xs][ys] == 0 || mat[xd][yd] == 0) {
            return -1;
        }
        if (xs == xd && ys == yd) {
            return 0;
        }
        int [] longestPathLength = new int [1];
        longestPathLength[0] = -1;
        findLongestPath(mat, xs, ys, xd, yd, longestPathLength, 0);
        return longestPathLength[0];
    }
    
    private static void findLongestPath(int [][] mat, int i, int j, int xd, int yd, int [] longestPathLength, int currentLength) {
        if (i == xd && j == yd && currentLength > longestPathLength[0]) {
            longestPathLength[0] = currentLength;
            return;
        }
        mat[i][j] = -1;
        for (int [] dir : direction) {
            int newX = dir[0] + i;
            int newY = dir[1] + j;
            if (isSafe(mat, newX, newY)) {
                mat[newX][newY] = -1;
                currentLength += 1;
                findLongestPath(mat, newX, newY, xd, yd, longestPathLength, currentLength);
                currentLength -= 1;
                mat[newX][newY] = 1;
            }
        }
        mat[i][j] = 1;
        
    }
    
    private static boolean isSafe(int [][] mat, int i, int j) {
        if (i < 0 || j < 0 || i >= mat.length || j >= mat[0].length || mat[i][j] != 1) {
            return false;
        }
        return true;
    }
}
        
