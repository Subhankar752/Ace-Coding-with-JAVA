// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String S = read.readLine().trim();
            Solution ob = new Solution();
            long ans = ob.countStrings(S); 
            System.out.println(ans);
        }
    } 
} // } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    long nC2(long x)
    {
        return (x*(x-1))/2;
    }
    
    long countStrings(String S) 
    {
        int n = S.length();
        long ans = nC2(n);
        
        char arr[] = S.toCharArray();
        
        boolean flag = false;
        
        int hashset[] = new int[26];
        
        
        for(int i=0; i<n; i++)
        {
            hashset[arr[i]-'a']++;
        }
        
        for(int i=0; i<26; i++)
        {
            if(hashset[i]>1)
            {
                flag = true;
                ans -= nC2(hashset[i]);
            }
            
        }
        
        if(flag) ans++;
        
        return ans;
        
    }
}