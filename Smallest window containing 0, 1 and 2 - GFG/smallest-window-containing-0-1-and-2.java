// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            int ans = ob.smallestSubstring(S);

            System.out.println(ans);
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {
    public int smallestSubstring(String S) {
        // Code here
         int[] arr = new int[3];
        int n = S.length();
        if(n < 3) return -1;
        int result = Integer.MAX_VALUE, index = 0;
        for (int i = 0; i < n; i++) {
            arr[S.charAt(i) - '0']++;
            while(arr[0] * arr[1] * arr[2] != 0 && index < n) {
                result = Math.min(result, i - index + 1);
                arr[S.charAt(index) - '0']--;
                index++;
            } 
        }
        
        while(arr[0] * arr[1] * arr[2] != 0 && index < n) {
            result = Math.min(result, n - index + 1);
            arr[S.charAt(index) - '0']--;
            index++;
        }
        
        return result == Integer.MAX_VALUE ? -1 : result;
    }
};
