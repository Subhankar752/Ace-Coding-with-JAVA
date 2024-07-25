class Solution {
    public boolean doesAliceWin(String s) {
        int co = 0;
        for (char c : s.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                co++;
            }
        }
        
        return (co == 0) ? false : true;
    }
}