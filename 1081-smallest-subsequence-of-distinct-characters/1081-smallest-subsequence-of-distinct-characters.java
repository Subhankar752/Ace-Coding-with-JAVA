class Solution {
    public String smallestSubsequence(String s) {
        int[] count = new int[26];
        for(char c : s.toCharArray())
            count[c - 'a']++;
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()){
            while(!st.isEmpty() && !st.contains(c) && c < st.peek() && count[st.peek() - 'a'] > 0){
                st.pop();
            }
            if(!st.contains(c))
                st.push(c);
            count[c - 'a']--;
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty())
            sb.append(st.pop());
        return sb.reverse().toString();
    }
}