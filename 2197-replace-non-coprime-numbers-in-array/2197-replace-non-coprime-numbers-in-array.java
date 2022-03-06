class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        for (int num: nums) {
            if (stack.isEmpty()) stack.push(num);
            else {
                while(!stack.isEmpty() && GCD(stack.peek(), num) > 1) {
                   num  = LCM(stack.pop(), num);
                }
                stack.push(num);
            }
        }
        return new ArrayList<>(stack);
    }
    
    private int GCD(int x, int y) {
        return y == 0 ? x : GCD(y, x%y);
    }
    
    private int LCM(int x, int y) {
        return x/GCD(x,y) * y;
    }
}