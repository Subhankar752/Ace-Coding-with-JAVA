// { Driver Code Starts
//Initial Template for Java


//Initial Template for Java


import java.io.*;
import java.util.*;


 // } Driver Code Ends
//User function Template for Java


 
class Solution
{ 
    // Method to calculate distinct sub-array 
    static int countDistinctSubarray(int arr[], int n) 
    { 
        // HashSet<Integer> hs = new HashSet<>();
        // for(int i : arr)
        //     hs.add(i);
        // int size = hs.size();
        // int ans = 0;
        // for(int i = 0 ; i < n ; i++){
        //     HashSet<Integer> h = new HashSet<>();
        //     for(int j = i ; j < n ; j++){
        //         h.add(arr[j]);
        //         if(h.size() == size)
        //             ans++;
        //     }
        // }
        // return ans;
        Set<Integer> set = new HashSet<>();
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i = 0 ; i < n ; i++)
        set.add(arr[i]);
        
        int dn = set.size();
        set.clear();
        
        if(dn == n)  return 1;
        
        for(int i = 0 ; i < dn ; i++)
        mp.put(arr[i] , mp.getOrDefault(arr[i] , 0) + 1);

        int l = 0, r = dn - 1 , count = 0;
        
        while(l <= (n - dn))
        {
            if(mp.size() == dn)
            {
                count += n-r;
                mp.put(arr[l] , mp.get(arr[l]) - 1);
                if(mp.get(arr[l]) == 0)
                {
                    mp.remove(arr[l]);
                }
                l++;
            }
            else if(r < n - 1)
            {
                r++;
                mp.put(arr[r] , mp.getOrDefault(arr[r] , 0) + 1);
            }
            else
            {
                break;
            }
        }
        return count;
    }
}


// { Driver Code Starts.

// Driver class
class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		// looping through all testcases
		while(testcases-- > 0){
		    int n=Integer.parseInt(br.readLine());
		    String line1 = br.readLine();
		    String[] a1 = line1.trim().split("\\s+");
		    int a[]=new int[n];
		    for(int i=0;i<n;i++)
		    {
		        a[i]=Integer.parseInt(a1[i]);
		    }
		    Solution ob=new Solution();
		    int ans=ob.countDistinctSubarray(a,n);
		    System.out.println(ans);
		    
		}
	}
}
  // } Driver Code Ends