// { Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*; 

class GFG{
	public static void main(String args[]) throws IOException { 
		
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t > 0){
       		int n = sc.nextInt();
			
			int arr[][] = new int[n][2];
          
        	for( int i=0 ; i<n ; i++ ){            
            	for( int j=0 ; j<2 ; j++ ){
                	arr[i][j] = sc.nextInt();
            	}
         	}
            
            solver solve = new solver();
			System.out.println( solve.max_non_overlapping(arr,n) ); 
			t--;
		}
	} 
}

// } Driver Code Ends


// ranges[i][0] is the start of ith range
// ranges[i][1] is the end of ith range

class solver
{
    static int max_non_overlapping(int ranges[][], int n){
        // code here
        Arrays.sort(ranges,(a,b)->{
           if(a[1] == b[1]){
               return a[0] - b[0];
           } 
           return a[1] - b[1];
        });
        int ans = 1;
        int pair[] = {ranges[0][0],ranges[0][1]};
        for(int i = 1; i<n; ++i){
            if(ranges[i][0]>=pair[1]){
               ++ans;
               pair[0] = ranges[i][0];
               pair[1] = ranges[i][1];
            }
        }
        return ans;
    }
}