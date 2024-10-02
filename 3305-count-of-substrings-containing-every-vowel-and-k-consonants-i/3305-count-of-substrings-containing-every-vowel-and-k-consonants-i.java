class Solution {
    public int countOfSubstrings(String s, int k) {
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            int a = 0, e = 0, m = 0, o = 0, u = 0, c = 0;
            for (int j = i; j < s.length(); j++) {
                char ch = s.charAt(j);
                if (ch == 'a')
                    a++;
                else if (ch == 'e')
                    e++;
                else if (ch == 'i')
                    m++;
                else if (ch == 'o')
                    o++;
                else if (ch == 'u')
                    u++;
                else
                    c++;

                if (a != 0 && e != 0 && m != 0 && o != 0 && u != 0 && (c == k)) {
                    ans++;
                }
            }
        }

        return ans;
    }
}