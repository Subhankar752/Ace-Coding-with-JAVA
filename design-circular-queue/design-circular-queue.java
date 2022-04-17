class MyCircularQueue {
    
    int[] arr;
    int size;
    int capacity;
    int head;
    int tail;

    public MyCircularQueue(int k) {
        this.arr=new int[k];
        this.capacity=k;
        this.size=0;
        this.head=0;
        this.tail=-1;
    }
    
    public boolean enQueue(int value) {
        if(isFull()==true)
            return false;
        tail=(tail+1)%capacity;
        arr[tail]=value;
        size++;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()==true)
            return false;
        head=(head+1)%capacity;
        size--;
        return true;
    }
    
    public int Front() {
        if(isEmpty()==true)
            return -1;
        return arr[head];
    }
    
    public int Rear() {
        if(isEmpty()==true)
            return -1;
        return arr[tail];
    }
    
    public boolean isEmpty() {
        if(size==0)
            return true;
        return false;
    }
    
    public boolean isFull() {
        if(size==capacity)
            return true;
        return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */