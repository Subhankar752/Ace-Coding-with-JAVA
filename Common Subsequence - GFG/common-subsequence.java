// { Driver Code Starts

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String a = sc.next ();
            String b = sc.next ();
            
            if (new Sol().commonSubseq(a, b))
                System.out.println (1);
                
            else
                System.out.println (0);
    		   
        }
        
    }
}

// Contributed By: Pranay Bansal

// } Driver Code Ends



class Sol
{
    Boolean commonSubseq (String a, String b)
    {
        // your code here  
        for(int i =0;i<a.length();i++)
       {
           String s = a.charAt(i)+"";
           if(b.contains(s))
           {
               return true;
           }
       }
       return false;
    }
}