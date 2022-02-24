// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.primeDivision(N);
            System.out.println(ans.get(0) + " " + ans.get(1));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
   static boolean ifPrime(int p){
for(int i=2;i<=p/2;i++)
{
if(p%i==0)
{
return false;

}
}
return true;
}

    static List<Integer> primeDivision(int N){
        // code here
       List<Integer> list=new ArrayList<>();
int x,y;
for(int i=2;i<=N;i++)
{ x=0;
y=0;
if(ifPrime(i)==true)
{
x=i;
y=N-x;
if(ifPrime(y)==true)
{
if(x+y==N)
{
list.add(x);
list.add(y);
break;
}
}
}
}
return list;
}}