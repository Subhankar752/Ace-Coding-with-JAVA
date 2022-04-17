class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
       int n = temperatures.length;
        int[] output = new int[n];
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0; i<n;i++){
            int curr = temperatures[i];
            while(!stack.isEmpty() && curr>temperatures[stack.peek()]){
                int prev = stack.pop();
                output[prev] = i-prev;
            }
            stack.push(i);
        }
        return output;
    }
}