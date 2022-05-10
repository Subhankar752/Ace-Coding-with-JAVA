// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String[] args) {

        // Taking input using class Scanner
        Scanner sc = new Scanner(System.in);

        // Taking total count of testcases
        int t = sc.nextInt();

        while (t-- > 0) {
            // taking total count of elements
            int n = sc.nextInt();

            // creating a new array of size n
            int arr[] = new int[n];

            // inserting elements to the array
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            Solution ob = new Solution();
            // calling firstRepeated method
            // and printing the result
            System.out.println(ob.firstRepeated(arr, n));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to return the position of the first repeating element.
    public static int firstRepeated(int[] arr, int n) {
        // Your code here
        int count = 0;
        ArrayList<Integer> dups=new ArrayList<Integer>();
      HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
          for(int x:arr){
              if(map.get(x)==null)
              map.put(x,count++);
              else{
                 dups.add(x); 
              count++;
              }
          }
          if(dups.size()==0)
          return -1;
          int min=map.get(dups.get(0));
          for(int x:dups){
              if(map.get(x)<min)
              min=map.get(x);
          }
          return min+1;
    }
}
