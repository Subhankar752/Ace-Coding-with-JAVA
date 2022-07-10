class Solution {
    public int fillCups(int[] amount) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int ans = 0;
        
        for(int i : amount)
        {
            if(i > 0)
              pq.add(i);
        }
        
        while(pq.size() > 1){
            int a = pq.remove();
            int b = pq.remove();
            a--;
            b--;
            ans++;
            if(a > 0)
                pq.add(a);
            if(b > 0)
                pq.add(b);
        }
        
        if(pq.size() == 1)
            ans += pq.remove();
        
        return ans;
    }
}