class Solution {

    public int minimumLength(String s) {
        int i = 0;
        int j = s.length() - 1;
        
        while (s.charAt(i) == s.charAt(j) && i < j) {
            char ch = s.charAt(i);
            
            while (ch == s.charAt(i) && i < j) i++;
            while (ch == s.charAt(j) && j >= i) j--;
        }
        return j - i + 1;
    }
}
