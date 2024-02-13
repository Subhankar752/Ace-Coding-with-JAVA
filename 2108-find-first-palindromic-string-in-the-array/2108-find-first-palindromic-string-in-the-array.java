class Solution {

    public String firstPalindrome(String[] words) {
        for (String s : words) {
            if (palin(s)) {
                return s;
            }
        }

        return "";
    }

    public boolean palin(String s) {
        StringBuilder sb = new StringBuilder(s);

        sb = sb.reverse();

        String rev = sb.toString();
        return rev.equals(s);
    }
}
