// { Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            int N = Integer.parseInt(br.readLine().trim());

            int arr[][] = new int[(int)(N)][2];

            for (int j = 0; j < 2; j++) {
                String inputLine2[] = br.readLine().trim().split(" ");
                for (int i = 0; i < N; i++) {
                    arr[i][j] = Integer.parseInt(inputLine2[i]);
                }
            }
            Solution ob = new Solution();
            System.out.println(ob.mostBalloons(N, arr));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int mostBalloons(int N, int points[][]) {
        // Code here
        if (points == null) return 0;
        int length = points.length;
        if (length <= 2) return length;
        int result = 0;
        for (int i = 0;i<points.length;i++){
            Map<Double, Integer> map = new HashMap<>();
            int count = 1;
            int same = 0;
            for (int j = 0;j<points.length;j++){
                //pick non matching points
                if(j != i){
                    //first point
                    int firstX = points[i][0];
                    int firstY = points[i][1];
                    
                    //second point
                    int secondX = points[j][0];
                    int secondY = points[j][1];
                    
                    //if both points are same, increment same points
                    if (firstX == secondX && firstY == secondY){ 
                        same++;
                        continue;
                    }
                    //if only x is different increment count
                    if (firstX == secondX) {
                        count++;                    
                        continue;
                    }
                    //for different points put in map the y/x
                    double k = (double)(secondY - firstY) / (double)(secondX - firstX);
                    map.put(k, map.getOrDefault(k, 1)+1);
                    //compute max with map value with number of same points
                    result = Math.max(result, map.get(k) + same);
                }
            }
            //update the result
            result = Math.max(result, count);
        }
        return result;
    }
}