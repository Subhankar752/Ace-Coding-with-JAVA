// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a, n);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solve {
    int[] findTwoElement(int arr[], int n) {
        // code here
        int[] check=new int[n+1];
       Arrays.fill(check,0);
       int[] ans=new int[2];
       for(int i=0;i<n;i++)
       {
           check[arr[i]]++;
       }
       for(int i=1;i<check.length;i++)
       {
           if(check [i]==2) ans[0]=i;
           if(check [i]==0) ans[1]=i;
       }
       return ans;
        // HashMap<Integer , Integer> map = new HashMap<>();
        // for(int i : arr){
        //     if(map.containsKey(i)){
        //         map.put(i , map.get(i) + 1);
        //     }
        //     else{
        //         map.put(i , 1);
        //     }
        // }
        // int[] ans = new int[2];
        // ans[1] = n;
        // for(Map.Entry<Integer , Integer> m : map.entrySet()){
        //     int key = m.getKey();
        //     int val = m.getValue();
        //     if(val == 2){
        //         ans[0] = key;
        //         break;
        //     }
        // }
        // TreeSet<Integer> hs = new TreeSet<>();
        // for(int i : arr)
        // hs.add(i);
        // int flag = 1;
        // for(int i : hs){
        //     if(i != flag){
        //         ans[1] = flag;
        //         break;
        //     }
        //     flag++;
        // }
        // return ans;
    }
}