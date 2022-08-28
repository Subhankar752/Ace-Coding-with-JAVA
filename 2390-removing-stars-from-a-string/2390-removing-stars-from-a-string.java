class Solution {
    public String removeStars(String s) {
        Stack<Character> st = new Stack<>();
        
        for(char c : s.toCharArray()){
            if(c == '*'){
                if(!st.isEmpty())
                    st.pop();
            }
            else{
                st.push(c);
            }
        }
        
        String ans = "";
        
        while(!st.isEmpty()){
            ans = st.pop() + ans;
        }
        
        return ans;
    }
}