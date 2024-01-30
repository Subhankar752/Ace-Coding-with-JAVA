class Solution {

    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for (String s : tokens) {
            if (check(s)) {
                int i2 = st.pop();
                int i1 = st.pop();

                if (s.equals("+")) {
                    st.push(i1 + i2);
                }
                if (s.equals("-")) {
                    st.push(i1 - i2);
                }
                if (s.equals("*")) {
                    st.push(i1 * i2);
                }
                if (s.equals("/")) {
                    st.push(i1 / i2);
                }
            } else {
                st.push(Integer.parseInt(s));
            }
        }
        
        return st.pop();
    }

    public boolean check(String s) {
        if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
            return true;
        }

        return false;
    }
}
