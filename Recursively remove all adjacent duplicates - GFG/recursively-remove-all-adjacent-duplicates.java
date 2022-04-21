// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){
            String S = br.readLine();
            Solution ob = new Solution();
            System.out.println(ob.remove(S));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    String remove(String s) {
        // code here
        String prev = s;
        StringBuilder curr = new StringBuilder();
        
        while (true) {
            int i = 0;
            
            while (i < prev.length() - 1) {
                if (prev.charAt(i) == prev.charAt(i + 1)) {
                    i++;
                    while (i < prev.length() && prev.charAt(i) == prev.charAt(i - 1)) {
                        i++;
                    }
                } else {
                    curr.append(prev.charAt(i));
                    i++;
                }
            }
            if (i < prev.length()) curr.append(prev.charAt(i));
            if (curr.length() == prev.length()) break;
            prev = curr.toString();
            curr = new StringBuilder();
        }
        return prev;
    }
}