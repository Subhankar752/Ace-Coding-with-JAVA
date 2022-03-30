// { Driver Code Starts
//Initial Template for Java

//Initial Template for Java

//Initial Template for Java

//Initial Template for Java

//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] element = line.trim().split("\\s+");
		    int sizeOfArray = Integer.parseInt(element[0]);
		    
		    int arr [] = new int[sizeOfArray];
		    
		    line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    
		    
		    Complete obj = new Complete();
		    long res = obj.calculate(arr, sizeOfArray);
		    System.out.println(res);
		}
	}
}




// } Driver Code Ends


//User function Template for Java


class Complete{
    
   
    // Function for finding maximum and value pair
    public static long calculate (int arr[], int n) {
        //Complete the function
        HashMap<Integer , Long> map = new HashMap<>();
        for(int i : arr){
            if(map.containsKey(i)){
                map.put(i , map.get(i) + 1);
            }
            else{
                map.put(i , 1L);
            }
        }
        long ans = 0;
        for(Map.Entry<Integer , Long> m : map.entrySet()){
            long value = m.getValue();
            long x = value * (value - 1)/2;
            ans += x;
        }
        return ans;
    }
    
    
}


