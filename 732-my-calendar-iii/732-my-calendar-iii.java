class MyCalendarThree {
    
    TreeMap<Integer,Integer> tm;
    int maxi = 0;

    public MyCalendarThree() {
        tm = new TreeMap<>();
    }
    
    public int book(int start, int end) {
        
        tm.put(start,tm.getOrDefault(start,0)+1);
        tm.put(end,tm.getOrDefault(end,0)-1);
        
        int cnt = 0;
        // iterate the cnt
        for (int val:tm.values()){
            cnt += val;
            // max element till now
            maxi = Math.max(cnt,maxi);
        }
        
        
        return maxi;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */