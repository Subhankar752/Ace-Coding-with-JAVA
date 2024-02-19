class Solution {

    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        
        int val = n & (n - 1);
        return val == 0;
    }
}
