// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String str = br.readLine().trim();
            Solution obj = new Solution();
            long ans = obj.findRank(str);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    // ArrayList<String> list = new ArrayList<>();
    // public long findRank(String S)
    // {
    //     // Code here
    //     char[] ch = S.toCharArray();
    //     Arrays.sort(ch);
    //     String st = new String(ch);
    //     solve(st , "");
    //     Collections.sort(list);
    //     // for(String s : list)
    //     // System.out.println(s);
    //     for(int i = 0 ; i < list.size() ; i++){
    //         if(list.get(i).equals(S))
    //         return (long)(i + 1);
    //     }
    //     return 0L;
    // }
    // public void solve(String st , String asf){
    //     if(st.length() == 0){
    //         list.add(asf);
    //         return;
    //     }
    //     for(int i = 0 ; i < st.length() ; i++){
    //         char ch = st.charAt(i);
    //         String temp = st.substring(0 , i) + st.substring(i + 1);
    //         solve(temp , asf + ch);
    //     }
    // }
    public static long fac(int a){ 
        long fact = 1;
        for(int i=1;i<=a;i++) 
            fact=fact*(long)i;    
        return fact;
} 
   public long findRank(String S)
   {
       if(S.length()==1) return 1;
       int[] a = new int[26];
       for(int i =0;i<S.length();i++) a[(int)S.charAt(i)-97]++;
       long p =1;
       int c = 0;
            for(int j =0;j<26;j++){
                       if(j == (int)S.charAt(c)-97){
                           a[j]=0;
                           c++;
                           j=-1;
                           if(c>=S.length()) break;
                       }
                       else if(a[j]>0) p = p+fac(S.length()-(c+1)); 
                   }  return p;}
}