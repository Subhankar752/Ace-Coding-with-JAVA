// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            String str = br.readLine();
            
            Solution obj = new Solution();
            System.out.println(obj.getNextEven(str));
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java

class Solution {
    
    public long getNextEven(String x)
    {
        // Your code goes here   
         while(true){
            
            // int n = x.length();
            int idx = -1;
            
            for(int i = 1; i < x.length(); i++){
                if(x.charAt(i) > x.charAt(i-1)){
                    idx = i;
                }
            }
            
            if(idx == -1){
                return (long)-1;
            }
            
            int index = idx;
            
            for(int i = idx; i < x.length() ;i++){
                if(x.charAt(i) > x.charAt(idx-1) && x.charAt(i) < x.charAt(idx) ){
                    index = i;
                }
            }
            
            char[] arr = x.toCharArray();
            
            char temp = arr[idx - 1];
            arr[idx - 1] = arr[index];
            arr[index] = temp;
            
            Arrays.sort(arr, idx, x.length());
            
            x = String.valueOf(arr);
            
            if((x.charAt(x.length()-1) - '0')%2 == 0 ){
                return Long.valueOf(x);
            }
         }
    }
}