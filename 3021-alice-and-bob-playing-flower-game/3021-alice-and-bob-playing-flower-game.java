class Solution {
    public long flowerGame(int n, int m) {
        long ans = 0;
        
        long xeven = (n / 2) * 1l;
        long xodd = (n / 2) * 1l;
        
        long yeven = (m / 2) * 1l;
        long yodd = (m / 2) * 1l;
        
        if (n % 2 == 1) {
            xodd++;
        }
        
        if (m % 2 == 1) {
            yodd++;
        }
        
        ans = (xeven * yodd) + (xodd * yeven);
        
        return ans;
    }
}