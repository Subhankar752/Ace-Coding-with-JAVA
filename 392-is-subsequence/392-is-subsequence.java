class Solution {
    public boolean isSubsequence(String s, String t) {
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()){
            st.push(c);
        }
        int n = t.length();
        for(int i = n - 1 ; i >= 0 ; i--){
            char ch = t.charAt(i);
            if(st.isEmpty())
                return true;
            if(ch == st.peek())
                st.pop();
        }
        return st.isEmpty();
    }
}