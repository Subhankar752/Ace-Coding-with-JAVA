class Solution {

    public String orderlyQueue(String s, int k) {
        if (k > 1) {
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            return new String(ch);
        }

        String ans = s;
        for (int i = 1; i < s.length(); i++) {
            String temp = s.substring(i) + s.substring(0, i);
            if (temp.compareTo(ans) < 0) {
                ans = temp;
            }
        }

        return ans;
    }
}
