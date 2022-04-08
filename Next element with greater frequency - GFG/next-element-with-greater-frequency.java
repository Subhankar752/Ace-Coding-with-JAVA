// { Driver Code Starts
import java.util.*;
import java.io.*;

class GFG
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        // int arr[] = new int[10000];
        
        int t = sc.nextInt();
        
        while(t-->0)
        {
            int n = sc.nextInt();
            int arr[]=new int[n];
            for(int i=0; i<n; i++)
            {
                arr[i] = sc.nextInt();
            }
            
            solver x = new solver();
            int res[]=x.print_next_greater_freq(arr,n);
            StringBuffer sb=new StringBuffer("");
            for(int i : res){
                sb.append(i+" ");
            }
            System.out.println(sb);
        }
    }
}
// } Driver Code Ends


class solver
{
    static int[] print_next_greater_freq(int arr[], int n)
    {
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int i : arr){
            if(map.containsKey(i)){
                map.put(i , map.get(i) + 1);
            }
            else{
                map.put(i , 1);
            }
        }
        
        int[] ans = new int[n];
        for(int i = 0 ; i < n ; i++)
        ans[i] = -1;
        
        
        for(int i = 0 ; i < n ; i++){
            int f1 = map.get(arr[i]);
            for(int j = i + 1 ; j < n ; j++){
                if(map.get(arr[j]) > f1){
                    ans[i] = arr[j]; 
                    break;
                }
            }
        }
        return ans;
    }
}

