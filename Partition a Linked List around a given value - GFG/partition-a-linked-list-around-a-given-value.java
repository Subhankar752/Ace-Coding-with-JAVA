// { Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
import java.lang.*;

class Node {
    int data;
    Node next;
    Node(int key) {
        data = key;
        next = null;
    }
}

class Partition {
    static Node head;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node tail = head;
            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                // addToTheLast(new Node(a));
                tail.next = new Node(a);
                tail = tail.next;
            }

            int k = sc.nextInt();
            Solution ob = new Solution();
            Node res = ob.partition(head, k);
            printList(res);
            System.out.println();
        }
    }

    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}// } Driver Code Ends


// User function Template for Java

/*class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

*/

class Solution {
    public static Node partition(Node node, int x) {
        // Your code here
        Node dummy = new Node(0);
       Node t=node;
       Node curr=node;
      ArrayList<Integer> o1 = new ArrayList<>();
      ArrayList<Integer> o2 = new  ArrayList<>();
       while(t!=null){
           o1.add(t.data);
           t=t.next;
       }
       for(int i=0;i<o1.size();){
           if(o1.get(i)<x){
               curr.data=o1.get(i);
                curr=curr.next;
           }
           i++;
       }
        for(int i=0;i<o1.size();){
           if(o1.get(i)==x){
               curr.data=o1.get(i);
                curr=curr.next;
           }
           i++;
       }
        for(int i=0;i<o1.size();){
           if(o1.get(i)>x){
               curr.data=o1.get(i);
                curr=curr.next;
           }
           i++;
       }
       return node;
    }
}