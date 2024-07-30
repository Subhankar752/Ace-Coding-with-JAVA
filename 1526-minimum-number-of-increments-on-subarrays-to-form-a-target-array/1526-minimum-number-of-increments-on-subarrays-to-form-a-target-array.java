class Solution {
    public int minNumberOperations(int[] target) {
        int ans = target[0];
        int opn = target[0];
        
        for (int i = 1 ; i < target.length ; i++) {
            if (target[i] > opn) {
                ans += target[i] - opn;
                opn = target[i];
            }
            else if (target[i] < opn) {
                opn = target[i];
            }
        }
        
        return ans;
    }
}