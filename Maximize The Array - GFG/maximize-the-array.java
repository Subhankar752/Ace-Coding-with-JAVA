// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

public class GFG {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr1 = new int[n], arr2 = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr1[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr2[i] = Integer.parseInt(inputLine[i]);
            }

            ArrayList<Integer> ans = new Solution().maximizeArray(arr1, arr2, n);
            for (Integer x : ans) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    ArrayList<Integer> maximizeArray(int[] arr1, int[] arr2, int n) {
        // code here
        ArrayList<ArrayList<Integer>> l=new ArrayList<>();
       HashSet<Integer> h=new HashSet<>();
       int ind=0;
       for(int i=0;i<n;i++){
           if(h.contains(arr2[i]))continue;
           ArrayList<Integer> list=new ArrayList<>();
           list.add(arr2[i]);
           list.add(ind++);
           l.add(list);
           h.add(arr2[i]);
       }
       for(int i=0;i<n;i++){
           if(h.contains(arr1[i]))continue;
           ArrayList<Integer> list=new ArrayList<>();
           list.add(arr1[i]);
           list.add(ind++);
           l.add(list);
           h.add(arr1[i]);
       }Collections.sort(l,(a,b)->b.get(0)-a.get(0));
       ArrayList<ArrayList<Integer>> list=new ArrayList<>();
       for(int i=0;i<Math.min(n,l.size());i++){
           list.add(l.get(i));
       }Collections.sort(list,(a,b)->a.get(1)-b.get(1));
       ArrayList<Integer> ans=new ArrayList<>();
       for(ArrayList<Integer> a:list){
           ans.add(a.get(0));
       }
       return ans;
    }
}