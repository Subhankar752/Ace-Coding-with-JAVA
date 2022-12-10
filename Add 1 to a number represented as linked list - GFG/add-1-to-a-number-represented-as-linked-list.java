//{ Driver Code Starts
import java.io.*;
import java.util.*;
class Node
{
    int data;
    Node next;
    
    Node(int x)
    {
        data = x;
        next = null;
    }
}
class GfG
{
    public static void printList(Node node) 
    { 
        while (node != null)
        { 
            System.out.print(node.data);
            node = node.next; 
        }  
        System.out.println();
    } 
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Node head = new Node( s.charAt(0) - '0' );
                    Node tail = head;
                    for(int i=1; i<s.length(); i++)
                    {
                        tail.next = new Node( s.charAt(i) - '0' );
                        tail = tail.next;
                    }
                    Solution obj = new Solution();
                    head = obj.addOne(head);
                    printList(head); 
                }
        }
}
// } Driver Code Ends


/*
class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
} 
*/

class Solution
{
    public static Node addOne(Node head) 
    { 
        //code here.
        
        Node temp = reverse(head);
        Node newHead = temp;
        int sum = 0;
        int carry = 1;
        
        while(temp != null){
           
            int curSum = temp.data + carry;
            
            sum = curSum % 10;
            carry = curSum / 10;
            temp.data = sum;
            temp = temp.next;
        }
        
        Node rev = reverse(newHead);
        Node newNode = null;
        
        if(carry > 0){
            newNode = new Node(carry);
            newNode.next = rev;
            return newNode;
        }
        else {
            return rev;
        }
        
    }
    public static Node reverse(Node head){
        Node prev = null;
        Node cur = head;
        
        while(cur != null){
            Node next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        
        return prev;
    }
}
