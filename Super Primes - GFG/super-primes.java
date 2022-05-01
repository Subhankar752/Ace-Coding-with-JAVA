// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.superPrimes(n));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
   
   void seive(int n, boolean arr[]){
       arr[0] = arr[1] = false;
       for(int i = 2 ; i*i < n ; i++){
           if(arr[i] == true){
               for(int j = 2*i ; j <= n ; j+=i){
                   arr[j] = false;
               }
           }
       }
   }
   
   int superPrimes(int n) {
       boolean arr[] = new boolean[n + 1];
       Arrays.fill(arr , true);
       seive(n , arr);
       int count = 0;
       for(int i = 5 ; i <= n ; i++){
           if(arr[i] == true && arr[i - 2] == true){
               count++;
           }
       }
       return count;
   }
}