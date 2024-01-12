class Solution {

    public boolean halvesAreAlike(String s) {
        s = s.toLowerCase();
        int n = s.length();
        int mid = n / 2;

        int fi = 0;
        int se = 0;

        for (int i = 0; i < mid; i++) {
            if (check(s.charAt(i))) {
                fi++;
            }
        }

        for (int i = mid; i < n; i++) {
            if (check(s.charAt(i))) {
                se++;
            }
        }

        return (fi == se);
    }

    public boolean check(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        }

        return false;
    }
}
