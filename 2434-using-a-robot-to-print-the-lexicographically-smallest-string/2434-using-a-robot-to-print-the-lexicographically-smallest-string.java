class Solution {
    public String robotWithString(String s) {
        int n = s.length();
        char[] min = new char[n];
        
        min[n - 1] = s.charAt(n - 1);
        for(int i = n - 2 ; i >= 0 ; i--){
            char c1 = min[i + 1];
            char c2 = s.charAt(i);
            
            if(c1 < c2){
                min[i] = c1;
            }
            else{
                min[i] = c2;
            }
        }
        
        // for(char c : min)
        //     System.out.println(c);
        
        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder();
        
        int i = 0;
        while(i < n){
            char ch = s.charAt(i);
            
            if(st.isEmpty()){
                st.push(ch);
                i++;
                continue;
            }
            
            while(!st.isEmpty() && st.peek() <= min[i]){
                ans.append(st.pop());
            }
            
            st.push(ch);
            i++;
        }
        
        while(!st.isEmpty()){
            ans.append(st.pop());
        }
        
        return ans.toString();
    }
}