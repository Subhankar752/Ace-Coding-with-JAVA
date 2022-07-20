class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int ans = 0;
       
        for(String i : words){
            if(check(i , s) == true)
                ans++;
        }
        
        return ans;
    }
    public boolean check(String word , String inputString){
//         Stack<Character> st = new Stack<>();
        
//         for(char c : s1.toCharArray()){
//             st.push(c);
//         }
        
//         int n = s2.length();
        
//         for(int i = n - 1 ; i >= 0 ; i--){
//             char ch = s2.charAt(i);
            
//             if(!st.isEmpty() && st.peek() == ch)
//                 st.pop();
//         }
        
//         return st.isEmpty();
        int prevCharIndex = 0;   // It will store the index of input String where previous char was found
        
        /*  So, the curr character should be found after this index for maintaining subsequence order  */
                
        for (char ch : word.toCharArray()) {
            
            int index = inputString.indexOf(ch, prevCharIndex);   // search for char after prev char found index
            
            // If index == -1 means char not found, else found at index i.
            
            if (index == -1) {
                return false;
            }
            
            prevCharIndex = index + 1;   // set the prevCharIndex to current found char index + 1 for next search
            
            // We do index + 1 as maybe duplicate elements consider this same index twice, so increment by 1.
            
        }
        
        return true;  
    }
}