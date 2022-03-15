class Solution {
    public String minRemoveToMakeValid(String s) {
        // int count = 0;
        // boolean lower = false;
        // for(char c : s.toCharArray()){
        //     if(Character.isLowerCase(c)){
        //         lower = true;
        //         break;
        //     }
        // }
        // if(lower == false)
        //     return "";
        // String ans = "";
        // for(char c : s.toCharArray()){
        //     if(c == '(')
        //         count++;
        //     if(c ==')')
        //         count--;
        // }
        // char ch = ' ';
        // if(count == 0)
        //     return s;
        // if(count > 0){
        //     ch = '(';
        // }
        // else{
        //     ch = ')';
        //     count = Math.abs(count);
        // }
        // for(char c : s.toCharArray()){
        //     if(ch == c && count > 0){
        //         count--;
        //     }
        //     else
        //         ans += c;
        // }
        // return ans;
        Stack<Integer> idx = new Stack<>();
        Stack<Character> st = new Stack<>();
        for(int i =0  ; i< s.length() ; i++){
            if(s.charAt(i) == '('){
                st.push('(');
                idx.push(i);
            }else if(s.charAt(i) == ')'){
                if(st.size()>0){
                    st.pop();
                    idx.pop();
                }else{
                    idx.push(i);
                }
            }
        }
        StringBuilder afterRemoval = new StringBuilder(s);
        while(idx.size()>0){
            afterRemoval.deleteCharAt(idx.pop());
        }
        return afterRemoval.toString();
            
    }
}