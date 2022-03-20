class Solution {
    public int halveArray(int[] nums) {
        int ans = 0;
        double sum = 0.0;
        PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : nums){
            sum += i;
            pq.add((double)i);
        }
        double d = sum;
        sum = sum/2.0;
        while(d > sum){
            double cur = pq.remove();
            cur = cur/2.0;
            d -= cur;
            pq.add(cur);
            ans++;
        }
        return ans;
    }
}