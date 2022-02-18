// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            int n = Integer.parseInt(read.readLine());
            
            String input_line[] = read.readLine().trim().split("\\s+");
            long a[]= new long[n];
            for(int i = 0; i < n; i++)
                a[i] = Long.parseLong(input_line[i]);

            Solution ob = new Solution();
            ob.prank(a, n); 

            for (int i=0;i<n;i++) 
                System.out.print(a[i]+" "); 
            System.out.println();
        }
    } 
} // } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    void prank(long[] a, int n)  
    { 
        // code here
      long[] b = new long[n];
      for(int i=0;i<n;i++){
          b[i]=a[(int)a[i]];
      }
       for(int i=0;i<n;i++){
           a[i]=b[i];
       }
        
    }
} 