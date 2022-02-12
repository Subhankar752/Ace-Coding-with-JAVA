class Solution {
    public boolean isValid(String str) {
        Stack<Character> store=new Stack<>();
        //int n=s.length();
        char check;
//         if(n%2!=0)
//             return false;
//         for(int i=0; i<s.length(); i++) {
//             char temp = s.charAt(i);
//             if(temp=='(' || temp=='{' || temp=='['){
//                 store.push(temp);
//             }
            
//             if (store.isEmpty()) 
//                 return false; 
            
//             if(temp==')') {
//                 check = store.pop();
//                    if (check == '{' || check == '[') 
//                     return false; 
//             } else if(temp=='}') {
//                 check = store.pop();
//                 if (check == '(' || check == '[') 
//                     return false;
//             } else if(temp==']') {
//                 check = store.pop();
//                 if (check == '{' || check == '(') 
//                     return false; 
//             }
//         }
        Stack<Character> st = new Stack<>();
            for(int i=0;i<str.length();i++){
                char ch = str.charAt(i);
                if(st.empty())
                    st.push(ch);
                else if(ch == '(' || ch == '{' || ch == '[')
                    st.push(ch);
                else{
                    if(ch == ')' && st.peek()=='(')
                        st.pop();
                    else if(ch == '}' && st.peek()=='{')
                        st.pop();
                    else if(ch == ']' && st.peek()=='[')
                        st.pop();
                    else
                        st.push(ch);
                }
            }
        return st.isEmpty();
    }
}