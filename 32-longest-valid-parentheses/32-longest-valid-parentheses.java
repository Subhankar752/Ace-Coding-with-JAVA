class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        char paranthesis[] = s.toCharArray();
        for(int i=0;i<paranthesis.length;i++) {
        	if(paranthesis[i] == '(') {
        		stack.push(i);
        	}else {
        		if(!stack.isEmpty()) {
        			int k = stack.pop();
        			paranthesis[k]='x';
        			paranthesis[i]='x';
        			
        		}
        	}
        }
        int count= 0;
        int max = 0;
        for(int i=0;i<paranthesis.length;i++) {
        	if(paranthesis[i] == 'x') {
        		count++;
        		max = Math.max(max, count);
        	}else {
        		count = 0;
        	}
        }
		return max;}
//         int max=0;
//         int n=s.length();
//         String str="";
//         for(int i=0;i<n;i++){
//             str=""+s.charAt(i);
//             for(int j=i+1;j<n;j++){
//                 str+=s.charAt(j);
//                 if(valid(str)){
//                     max=Math.max(max,(j-i+1));
//                 }
//             }
//         }
        
//         return max;
//     }
//     }
//     public static boolean valid(String str){
//         Stack<Character> st=new Stack<>();
//         int n=str.length();
//         for(int i=0;i<n;i++){
//             char ch=str.charAt(i);
//             if(ch=='(')
//                 st.push(ch);
//             else{
//                 if(st.isEmpty())
//                     return false;
//                 char x=st.pop();
//                 if(x==')')
//                     return false;
//             }
//         }
//         return st.isEmpty();
//     }
}