class Solution {
    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int mod = (int)Math.pow(10 , 9) + 7;
        for(int i : nums){
            pq.add(i);
        }
        
        for(int i = 0 ; i < k ; i++){
            int r = pq.remove();
            r += 1;
            pq.add(r);
        }
        long product = 1;
        
        while(!pq.isEmpty()){
            long curr = (long)pq.poll();
            product = ((product % mod) * (curr % mod)) % mod;
        }
        return (int)(product % mod);
    }
}