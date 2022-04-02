class Solution {
    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while(i < j){
            char c1 = s.charAt(i);
            char c2 = s.charAt(j);
            if(c1 == c2){
                i++;
                j--;
            }
            else{
                return (check(s , i) || check(s , j));
            }
        }
        return true;
    }
    public boolean check(String st , int idx){
        String temp = st.substring(0 , idx) + st.substring(idx + 1);
        int i = 0;
        int j = temp.length() - 1;
        while(i < j){
            char c1 = temp.charAt(i);
            char c2 = temp.charAt(j);
            if(c1 != c2)
                return false;
            i++;
            j--;
        }
        return true;
    }
}