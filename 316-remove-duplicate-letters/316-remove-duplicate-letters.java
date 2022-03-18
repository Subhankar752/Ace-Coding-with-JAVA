class Solution {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        for(char c : s.toCharArray()){
            count[c - 'a']++;
        }
        Stack<Character> st = new Stack<>();
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            while(!st.isEmpty() && !st.contains(ch) && count[st.peek() - 'a'] > 0 && st.peek() > ch)
                st.pop();
            if(!st.contains(ch))
                st.push(ch);
            count[ch - 'a']--;
        }
        StringBuilder str = new StringBuilder();
        while(!st.isEmpty())
            str.append(st.pop());
        return str.reverse().toString();
    }
}