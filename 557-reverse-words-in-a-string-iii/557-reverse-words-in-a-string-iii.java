class Solution {
    public String reverseWords(String s) {
        String ans = "";
        String temp = "";
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
           
            if(ch == ' '){
                ans += temp + " ";
                temp = "";
            }
            else{
                temp = ch + temp;
            }
        }
        ans += temp;
        return ans;
    }
}