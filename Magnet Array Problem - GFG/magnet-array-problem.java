// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            double a[] = new double[(int)(n)];
            double getAnswer[] = new double[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Double.parseDouble(inputLine[i]);
            }
            
            Solution obj = new Solution();
            obj.nullPoints(n, a, getAnswer); 
            
            StringBuilder output = new StringBuilder();
            for(int i=0;i<n-1;i++)
                output.append(String.format("%.2f", getAnswer[i])+" ");
                
            System.out.println(output);
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java

class Solution {
    
    public void nullPoints(int n, double magnets[], double getAnswer[])
    {
        // Your code goes here 
        for(int i = 0 ; i < n - 1 ; i++)
        {
            double low = magnets[i];
            double high = magnets[i + 1];
         while(low <= high)
         {
            double mid = low + (high - low) / 2;
            double left = 0.00 , right = 0.00;
            for(int j = i + 1 ; j < n ; j++)  left += (1 / (magnets[j] - mid));
                
            for(int j = i ; j >= 0 ; j--) right += (1 / (mid - magnets[j]));
                
            if((Math.abs(right - left) < 0.000001))
            {
             getAnswer[i] = mid;
            break;
            }
            else if(left < right) low = mid;
            else  high = mid; 
            }
        }
    }
}


