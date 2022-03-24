class Solution {
    public int calculate(String s) {
       s = s + "+";
        
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        Stack<Integer> stack = new Stack<>();
        int curNum = 0;
        char op = '+';
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                continue;
            }
            
            if (Character.isDigit(c)) {
                curNum = curNum * 10 + (c - '0');
            }
            
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                if (op == '+') {
                    stack.push(curNum);
                }
                
                if (op == '-') {
                    stack.push(-curNum);
                }
                
                if (op == '*') {
                    stack.push(stack.pop() * curNum);
                }
                
                if (op == '/') {
                    stack.push(stack.pop() / curNum);
                }
                
                curNum = 0;
                op = c;
            }
        }
        
        int result = 0;
        while (!stack.empty()) {
            result += stack.pop();
        }
       
        return result;
    }
}