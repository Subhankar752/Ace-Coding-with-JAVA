// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String str = br.readLine();
            
            Solution obj = new Solution();
            System.out.println(obj.findSubString(str));
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public int findSubString( String str) {
        // Your code goes here
        HashSet<Character> hs = new HashSet<>();
        HashMap<Character,Integer> count = new HashMap<Character,Integer>();
        
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            hs.add(ch);
        }
        
        int unique = hs.size(),i=0,j=0,min=Integer.MAX_VALUE;
        
        while(j<str.length()){
            if(count.containsKey(str.charAt(j))){
                int freq = count.get(str.charAt(j));
                count.put(str.charAt(j),freq+1);
            }else{
                count.put(str.charAt(j),1);
            }
            
            while(count.size()== unique && i<str.length()){
                //System.out.println(i+" "+j+ " " + count);
                min = Math.min(min,j-i+1);
                
                char c = str.charAt(i);
                
                if(count.containsKey(c)){
                    int freq = count.get(c);
                    if(freq == 1) count.remove(c);
                    else count.put(c,freq-1);
                }
                i++;
            }
            
            j++;
        }
        
        return min;
    }
}