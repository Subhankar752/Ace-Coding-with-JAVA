class Solution {
    public int reverse(int x) {
        int result = 0;
        
        while(x != 0) {
        
            
            try {
                
                result = Math.multiplyExact(result, 10);                
                result = Math.addExact(result, x % 10);
                
            } catch (ArithmeticException ex) {
                return 0;
            }
            
            x /= 10;
        }
        
        
        return result;
    }
}