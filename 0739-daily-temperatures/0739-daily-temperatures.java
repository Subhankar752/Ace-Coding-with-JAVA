class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
       Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        for(int i = res.length - 1; i >= 0; i--){
            while(!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]){
                stack.pop();
            }
            res[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return res;
    }
}