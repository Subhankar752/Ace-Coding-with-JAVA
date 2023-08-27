class Solution {
    public long minimumPossibleSum(int n, int k) {
        HashSet<Long> hs = new HashSet<>();
        
        long val = 1;
        int i = 0;
        long sum = 0;
        
        while(i < n) {
            
            if(!hs.contains(k - val)) {
                hs.add(val);
                sum += val;
                i++;
            }
            
            val++;
        }
        
        return sum;
    }
}