class Solution {
    public int minimumSum(int n, int k) {
        HashSet<Integer> hs = new HashSet<>();
        
        int val = 1;
        int i = 0;
        int sum = 0;
        
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