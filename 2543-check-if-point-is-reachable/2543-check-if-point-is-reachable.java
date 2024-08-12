class Solution {
    
    public boolean isReachable(int targetX, int targetY) {
    int g = gcd(targetX, targetY);
    return (g & (g - 1)) == 0; 
    }
    
    private int gcd(int a, int b) {
        if (b == 0) 
            return a;
        return gcd(b, a % b);
    }
}