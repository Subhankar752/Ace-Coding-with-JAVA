// { Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Driverclass
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
		int t = Integer.parseInt(br.readLine().trim());
		
	    while(t-- >0)
	    {
	        String inputLine[] = br.readLine().trim().split(" ");
	        
	        //taking n and sum
            int n = Integer.parseInt(inputLine[0]);
            int sum = Integer.parseInt(inputLine[1]);
            
            //calling largestNumber() function
            System.out.println(new Solution().largestNumber(n, sum));
	    }
    }
}// } Driver Code Ends



class Solution
{
    //Function to return the largest possible number of n digits
    //with sum equal to given sum.
    static String largestNumber(int n, int sum)
    {
        // add your code here
        int[] a = new int[n];
        int max = 9 * n;
        if(max < sum)
            return "-1";
            int idx = 0;
        while(sum > 0){
            int min = Math.min(sum , 9);
            sum -= min;
            a[idx++] = min;
        }
        String ans = "";
        for(int i : a){
            ans += Integer.toString(i);
        }
        return ans;
    }
}


