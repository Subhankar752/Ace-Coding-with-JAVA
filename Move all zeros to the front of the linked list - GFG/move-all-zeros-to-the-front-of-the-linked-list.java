// { Driver Code Starts
//Initial Template for Java

import java.util.*;
class Node{
    int data;
    Node next;
    Node(int d){
        data=d;
        next=null;
    }
}
class Zeroes{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            Node head=null;
            while(n-->0){
                int a=sc.nextInt();
                if(head==null){
                    head=new Node(a);
                }
                else{
                    Node temp=new Node(a);
                    temp.next=head;
                    head=temp;
                }
            }
            GfG g=new GfG();
            head = g.moveZeroes(head);
            while(head!=null){
                System.out.print(head.data+" ");
                head=head.next;
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java

/*
class Node{
    int data;
    Node next;
    Node(int d){
        data=d;
        next=null;
    }
}
*/

class GfG{
    public Node moveZeroes(Node head){
        //Your Code here.
        Node temp = new Node(0);
        Node fin = temp;
        int count = 0;
        Node res = head;
        ArrayList<Integer> st = new ArrayList<>();
        
        while(res != null){
            if(res.data == 0)
            count++;
            else
            st.add(res.data);
            res = res.next;
        }
        for(int i = 0 ; i < count ; i++){
            temp.next = new Node(0);
            temp = temp.next;
        }
        
        for(int i : st){
            temp.next = new Node(i);
            temp = temp.next;
        }
        return fin.next;
    }
}