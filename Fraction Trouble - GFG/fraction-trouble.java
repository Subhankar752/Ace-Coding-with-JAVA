// { Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] input = new String[2]; 
            input = br.readLine().split(" "); 
            int n = Integer.parseInt(input[0]); 
            int d = Integer.parseInt(input[1]); 
            Solution ob = new Solution();
            int[] ans = ob.numAndDen(n,d);
            for(int i = 0; i < ans.length; i++)
            {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
    public int[] numAndDen(int n, int d)
    {
        // code here
        int[] b = new int[2];
       long max = Integer.MIN_VALUE;
       for(int q =10000;q>=2;q--){
           int p = ((q*n)-1)/d;
           long v = ((long)p*(long)10000000)/(long)(q);
           if(max<v && p<=q) {max=v;b[0]=p;b[1]=q;}
       } return b;
    }
}