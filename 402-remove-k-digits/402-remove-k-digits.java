class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        int n = num.length();
        for(char ch : num.toCharArray()){
            if(st.isEmpty() && ch != '0')
                st.push(ch);
            else if(!st.isEmpty() && k > 0){
                while(!st.isEmpty() && k > 0 && st.peek() > ch){
                    st.pop();
                    k--;
                }
                if(!st.isEmpty() || ch != '0')
                    st.push(ch);
            }
            else if(!st.isEmpty())
                st.push(ch);
        }
        while(k > 0 && !st.isEmpty()){
            st.pop();
            k--;
        }
        if(st.isEmpty())
            return "0";
        String ans = "";
        while(!st.isEmpty()){
            ans = st.pop() + ans;
        }
        return ans;
        
    }
}