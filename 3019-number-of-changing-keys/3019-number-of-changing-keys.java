class Solution {

    public int countKeyChanges(String s) {
        s = s.toLowerCase();
        int ans = 0;

        char prev = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (ch != prev) {
                ans++;
            }
            prev = ch;
        }

        return ans;
    }
}
