class MinStack {
   Stack<Integer> s=new Stack<>();
    Stack<Integer> ss=new Stack<>();
    /** initialize your data structure here. */
    public MinStack() {
        Stack<Integer> s=new Stack<>();
        this.s=s;
    }
    
    public void push(int val) {
        s.push(val);
        if(ss.size()==0 || ss.peek()>=val)
            ss.push(val);
    }
    
    public void pop() {
        int ans=s.pop();
        if(ss.peek() == ans)
            ss.pop();
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return ss.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */