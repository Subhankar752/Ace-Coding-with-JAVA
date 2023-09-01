class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a,b) -> a[0] - b[0]);
        
        int ans = 0;
        int i = 0;
        int day = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = events.length;
        
        while(i < n || !pq.isEmpty()) {
            if(pq.isEmpty()) {
                day = events[i][0];
            }
            
            while(i < n && day == events[i][0]) {
                pq.add(events[i][1]);
                i++;
            }
            
            pq.remove();
            day++;
            ans++;
            
            while(!pq.isEmpty() && pq.peek() < day) {
                pq.remove();
            }
        }
        
        
        
        return ans;
    }
}