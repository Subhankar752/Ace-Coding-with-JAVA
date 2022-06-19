// { Driver Code Starts
//Initial Template for Java

//Initial Template for Java
import java.io.*;
import java.util.*;
class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
class insertion
{
    Node head;  
    Node tail;
	public void addToTheLast(Node node) 
	{
	  if (head == null) 
	  {
	   head = node;
	   tail = node;
	  } 
	  else 
	  {
	   tail.next = node;
	   tail = node;
	  }
	}
      void printList(Node head)
    {
        Node temp = head;
        while (temp != null)
        {
           System.out.print(temp.data+" ");
           temp = temp.next;
        }  
        System.out.println();
    }
	/* Drier program to test above functions */
	public static void main(String args[])throws IOException
    {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // Scanner sc = new Scanner(System.in);
		 int t=Integer.parseInt(br.readLine());
		 while(t>0)
         {
            String S[] = br.readLine().split(" ");
			int N = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            int n = Integer.parseInt(S[2]);
		
		    String S1[] = br.readLine().split(" ");
			insertion llist = new insertion(); 
			int a1=Integer.parseInt(S1[0]);
			Node head= new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < N; i++) 
			{
				int a = Integer.parseInt(S1[i]);
				llist.addToTheLast(new Node(a));
			}
			
        Solution ob = new Solution();
		Node newhead=ob.reverseBetween(llist.head, m, n);
		llist.printList(newhead);
		
        t--;		
        }
    }}// } Driver Code Ends


//User function Template for Java

/*
class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
    */
class Solution
{
    public static Node reverseBetween(Node head, int m, int n)
    {
        //code here
        Node st = new Node(-1);
        st.next = head;
        
        //A counter for keeping track of the 3 parts.
        int count = 0;
        
        
        //Find the start of the third part.
        Node thirdPartStart = head;
        while(count<n)
        {
            thirdPartStart = thirdPartStart.next;
            count++;
        }
        
        
        
        
        //Find the end of the first part.
        Node firstPartEnd = st;
        count = 1;
        while(count<m)
        {
            firstPartEnd = firstPartEnd.next;
            count++;
        }
        
        
        
        //Join the first part with the reversed second part.
        firstPartEnd.next = rev(firstPartEnd.next, thirdPartStart, m, n);
        
        
        
        //All three parts are joined together. Return start's next.
        return st.next;
        
    }
    private static Node rev(Node head, Node prev, int m, int n)
    {
        //Perform reversal for (m-n+1) iterations.
        for(int i=m; i<=n; i++)
        {
            Node next = head.next;
            
            //In the first iteration, second part's first node is and third part are joined.
            head.next = prev;
            
            prev = head;
            
            head = next;
        }
        
        
        //We return the head of the reversed LL which will be joined to the first part.
        return prev;
    }
}