class Solution {

    public String removeKdigits(String nums, int k) {
        if (nums.length() == k) return "0";
        
        Stack<Character> st = new Stack<>();
        
        for (int i = 0; i < nums.length(); i++) {
            while (!st.isEmpty() && k > 0 && st.peek() > nums.charAt(i)) {
                st.pop();
                k--;
            }
            st.push(nums.charAt(i));
        }

        while (k > 0) {
            st.pop();
            k--;
        }
        
        StringBuilder s = new StringBuilder();
        
        while (!st.isEmpty()) {
            s.append(st.pop());
        }
        
        s.reverse();
        
        while (s.length() > 1 && s.charAt(0) == '0') s.deleteCharAt(0);
        
        return s.toString();
    }
}
