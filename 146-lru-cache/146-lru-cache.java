class LRUCache {
    class Node{
     int key;
     int val;
     Node prev,next;
    
    Node(int key,int val){
        this.key=key;
        this.val=val;
        this.prev=null;
        this.next=null;
     }
    }
    
    Map<Integer, Node> map=new HashMap<>();
    Node head=new Node(0,0);
    Node tail=new Node(0,0);
    private int capacity;
    
    public LRUCache(int capacity) {
        this.capacity=capacity;
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            int res=map.get(key).val;
            delNode(key);
            insertNode(key,res);
            return res;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
             delNode(key);
             insertNode(key,value);
        }
        
        else if(capacity==map.size()){
            delNode(tail.prev.key);
            insertNode(key,value);
        }
        
        else{
            insertNode(key,value);
        }
    }
    
    public void insertNode(int key, int val){
        Node temp=new Node(key,val);
        temp.next=head.next;
        head.next.prev=temp;
        temp.prev=head;
        head.next=temp;
        map.put(key,temp);
    }
    
    public void delNode(int key){
        Node node=map.get(key);
        node.prev.next=node.next;
        node.next.prev=node.prev;
        node.next=null;
        node.prev=null;
        map.remove(key);
    }
}