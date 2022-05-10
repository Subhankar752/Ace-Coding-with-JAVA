// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main{
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int s = sc.nextInt();

            int[] m = new int[n];
            for (int j = 0; j < n; j++) {
                m[j] = sc.nextInt();
            }
            
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.subarraySum(m, n, s);
            for(int ii = 0;ii<res.size();ii++)
                System.out.print(res.get(ii) + " ");
            System.out.println();
        }
    }

}// } Driver Code Ends


class Solution
{
    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
        // Your code here
        int cursum=0;
        int start=0,end=-1;
        HashMap<Integer, Integer> map=new HashMap<>();
        ArrayList<Integer> ar=new ArrayList<>();
        for(int i=0;i<n;i++){
            cursum+=arr[i];
            if(cursum-s==0){
                start=1;
                end=i+1;
                ar.add(start);
                ar.add(end);
               break;
            }
            if(map.containsKey(cursum-s)){
                start=map.get(cursum-s)+2;
                end=i+1;
                ar.add(start);
                ar.add(end);
                break;
            }
            
            map.put(cursum,i);
        }
        if(end==-1){
            ar.add(-1);
        }
        return ar;
    }
}