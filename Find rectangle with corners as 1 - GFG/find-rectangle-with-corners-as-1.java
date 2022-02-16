// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.HashMap; 
import java.util.HashSet; 

class GFG{
	public static void main(String args[]) throws IOException { 
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t > 0){
       		int rows=sc.nextInt();
       		int columns=sc.nextInt();
			
			int matrix[][]=new int[rows][columns];
          
        	for(int i=0; i<rows;i++){            
            	for(int j=0; j<columns;j++){
                	matrix[i][j]=sc.nextInt();
            	}
         	}

			Solution x = new Solution();
			if (x.ValidCorner(matrix)) 
				System.out.println("Yes"); 
			else
				System.out.println("No"); 
			t--;
		}
	} 
}
	


// } Driver Code Ends


//User function Template for Java

public class Solution { 
	static boolean ValidCorner(int mat[][]) 
	{ 
	    // Your code goes here
	    int n=mat.length;
    int m=mat[0].length;
    for(int i=0;i<n;i++){
        for(int j=i+1;j<n;j++){
            int cnt=0;
            for(int k=0;k<m;k++){
                if((mat[i][k]+mat[j][k])==2){
                    cnt++;
                }
            }
            
            if(cnt>=2){
                return true;
            }
        }
    }
    return false;
	}
}