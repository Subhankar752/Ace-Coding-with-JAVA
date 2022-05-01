class Solution {
    public boolean backspaceCompare(String s, String t) {
         String s1 = solve(s);
        String s2 = solve(t);
        return s1.equals(s2);
    }
    public String solve(String s){
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '#'){
                if(!st.isEmpty())
                    st.pop();
            }
            else{
                st.push(c);
            }
        }
        String ans = "";
        while(!st.isEmpty())
            ans += st.pop();
        return ans;
    }
}