class KthLargest {
    Queue<Integer> queue = new PriorityQueue<>();
    int k;
    public KthLargest(int k, int[] nums) 
    {
        this.k = k;
        
        for(int i : nums)
        {
            queue.add(i);
        }
    }
    
    public int add(int val) 
    {
        queue.add(val);
        
        while(queue.size() > k)
        {
            queue.poll();
        }
        
        return queue.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */