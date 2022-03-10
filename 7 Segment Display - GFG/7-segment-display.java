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
            int N = Integer.parseInt(read.readLine());
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.sevenSegments(S,N));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    static String sevenSegments(String S, int n) {
        // code here
         int[] l = new int[10];
       l[0]=6;l[1]=2;l[2]=5;l[3]=5;l[4]=4;
       l[5]=5;l[6]=6;l[7]=3;l[8]=7;l[9]=5;
       int[] no = {0,1,2,4,7,8};
       int line = 0;
       StringBuilder str = new StringBuilder("");
       for(int i =0;i<n;i++) line=line+l[Integer.parseInt(S.charAt(i)+"")];
       if(line == n*7 || line == n*1) return S;
        for(int i =0;i<6;i++){
            int a = line+2-(2*n)-l[no[i]];
            if(a%4==0 && (a/4)<n){
                int zero = a/4;
                int one = n-1-zero;
                if(no[i]==0) zero=zero+1;
                    while(zero>0){ str.append("0");zero--;}
                    while(one>0){ str.append("1");one--;}
               if(no[i]!=0) str.append(no[i]);
               return str.toString();
            } 
        }
        int x = 7*n - line;
        int y = n-x;
        while(x>0){
            str.append("0");
            x--;
        }
        while(y>0){
            str.append("8");
            y--;
        }   
   return str.toString();
    }
};