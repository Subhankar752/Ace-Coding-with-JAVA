// { Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Array
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine());
            String st[] = read.readLine().trim().split("\\s+");
            
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
              arr[i] = Integer.parseInt(st[i]);
              
            System.out.println(new Solution().minNumber(arr,0,n-1));
        }
    }
    
}// } Driver Code Ends




class Solution
{
    //Function to find the minimum element in sorted and rotated array.
    static int minNumber(int arr[], int low, int high)
   {
       int p=find_pivot(arr,low,high);
      // System.out.println(p);
       return arr[(p+1)];
   }
   static int find_pivot(int[] arr,int l,int h)
   {
       int mid=(l+h)/2;
       if(l>h)
       return -1;
       if(mid>l && arr[mid]<arr[mid-1])
       return mid-1;
       if(mid < h && arr[mid+1]<arr[mid])
       return mid;
       if(arr[0]>arr[mid])
       return find_pivot(arr,l,mid-1);
       return find_pivot(arr,mid+1,h);
}
}