class MyLinkedList {
    class Node{
        int val;
        Node next;
        
        public Node(int val){
            this.val = val;
        }
        public Node(int val, Node next){
            this.val = val;
            this.next = next;
        }
    }
    private int count = 0;
    private Node head = null;
    private Node tail = null;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index < 0 || index >= count) return -1;
        Node curr = head;
        while(index > 0){
            curr = curr.next;
            --index;
        }
        return curr.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node n = new Node(val);
        n.next = head;
        if(head == null) 
            tail = n;
        head = n;
        ++count;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        ++count;
        Node n = new Node(val);
        if(tail != null)
            tail.next = n;
        else
            head = n;
        tail = n;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index > count) return;
        if(index <= 0) 
            addAtHead(val);
        else if(index == count) 
            addAtTail(val);
        else{
            Node curr = head;
            while(index > 1){
                curr = curr.next;
                --index;
            }
            Node n = new Node(val);
            n.next = curr.next;
            curr.next = n;
            ++count;
        }
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index < 0 || index >= count) return;
        --count;
        if(index == 0){
            Node n = head.next;
            head = n;
            if(n != null) 
                n.next = null;
            if(head == null) 
                tail = null;
        }else{
            int idx = index;
            Node curr = head;
            while(index > 1){
                curr = curr.next;
                --index;
            }
            Node n = curr.next;
            curr.next = n.next;
            n.next = null;
            if(idx == count)
                tail = curr;
        }
    }
}