class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : stones)
            pq.add(i);
        while(pq.size() > 1){
            int first = pq.remove();
            int second = pq.remove();
            if(first == second)
                continue;
            first -= second;
            pq.add(first);
        }
        if(pq.size() > 0)
        return pq.remove();
        return 0;
    }
}