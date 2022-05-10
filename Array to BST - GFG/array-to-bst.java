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
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            int[] ans = obj.sortedArrayToBST(nums);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    
    int idx = 0;
    
    public int[] sortedArrayToBST(int[] nums)
    {
        // Code here 
        int n = nums.length;
        Node root = solve(nums , 0 , n - 1);
        int[] ans = new int[n];
        preorder(root , ans);
        return ans;
    }
    public void preorder(Node root , int[] ans){
        if(root == null)
        return;
        ans[idx++] = root.data;
        preorder(root.left , ans);
        preorder(root.right , ans);
    }
    public Node solve(int[] nums, int l, int r)
   {
       if(l > r)
       return null;
       
       int mid = l+(r-l)/2;
       Node t = new Node(nums[mid]);
       t.left = solve(nums,l,mid-1);
       t.right = solve(nums,mid+1,r);
       return t;
   }
}