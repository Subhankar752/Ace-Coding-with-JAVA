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
            String S[] = read.readLine().split(" ");
            
            int n = Integer.parseInt(S[0]);
            int e = Integer.parseInt(S[1]);
            
            String S1[] = read.readLine().split(" ");
            String S2[] = read.readLine().split(" ");
            
            int[] A = new int[2*e];
            int[] B = new int[2*e];
            
            for(int i=0; i<2*e; i++)
            {
                A[i] = Integer.parseInt(S1[i]);
                B[i] = Integer.parseInt(S2[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.checkMirrorTree(n,e,A,B));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    static int checkMirrorTree(int n, int e, int[] a, int[] b) {
        // code here
        int length = 2 * e;
        Map<Integer, Stack<Integer>> map = new HashMap<>();
        for (int i = 0; i < length; i+=2) {
            map.computeIfAbsent(a[i], x -> new Stack<>()).push(a[i + 1]);
        }
        for (int i = 0; i < length; i+=2) {
            if (map.get(b[i]).pop() != b[i + 1]) {
                return 0;
            }
        }
        return 1;
    }
};