class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> st = new Stack<>();
        for(String  i : ops){
            if(i.equals("+")){
                int a = st.pop();
                int b = st.pop();
                int c = a + b;
                st.push(b);
                st.push(a);
                st.push(c);
            }
            else if(i.equals("D")){
                int a = st.peek();
                a *= 2;
                st.push(a);
            }
            else if(i.equals("C")){
                st.pop();
            }
            else{
                st.push(Integer.parseInt(i));
            }
        }
        int ans = 0;
        while(!st.isEmpty()){
            ans += st.pop();
        }
        return ans;
    }
}