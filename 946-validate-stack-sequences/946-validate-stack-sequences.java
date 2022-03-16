class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();
        int idx = 0;
        for(int i = 0 ; i < pushed.length ; i++){
            if(st.isEmpty())
                st.push(pushed[i]);
            else{
                while(!st.isEmpty() && popped[idx] == st.peek()){
                    st.pop();
                    idx++;
                }
                st.push(pushed[i]);
            }
        }
         while(!st.isEmpty() && popped[idx] == st.peek()){
                    st.pop();
                    idx++;
                }
        return st.isEmpty();
    }
}