// { Driver Code Starts
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
		    
		    int arr [][] = new int[sizeOfArray][2];
		    
		    for(int i = 0;i<sizeOfArray;i++){
    		    line = br.readLine();
    		    String[] elements = line.trim().split("\\s+");
		        arr[i][0] = Integer.parseInt(elements[0]);
		        arr[i][1] = Integer.parseInt(elements[1]);
		    }
		    
		    Complete obj = new Complete();
		    ArrayList<Integer> ans;
		    ans = obj.permute(arr, sizeOfArray);
		    for(int i: ans)
		        System.out.println(i);
		}
	}
}


// } Driver Code Ends


//User function Template for Java

class Complete{
    
   static class Pair{
       int a;
       int b;
       Pair(int a , int b){
           this.a = a;
           this.b = b;
       }
   }
   
    // Function for finding maximum and value pair
    public static ArrayList<Integer> permute (int arr[][], int n) {
        //Complete the function
        ArrayList<Pair> a = new ArrayList<>();
        int c = 1;
        for(int[] i : arr){
            int x = i[0];
            int y = i[1];
            int sum = x + y;
            a.add(new Pair(sum , c));
            c++;
        }
        Collections.sort(a , (aa , bb) -> (aa.a > bb.a) ? 1 : (aa.a == bb.a) ? aa.b - bb.b : -1);
        // for(Pair p : a)
        // System.out.println(p.a + " " + p.b);
        ArrayList<Integer> ans = new ArrayList<>();
        for(Pair p : a){
            ans.add(p.b);
        }
        return ans;
    }
    
    
}


