class Solution {

    public String minimizeStringValue(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            if (c == '?') continue;
            freq[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '?') {
                char minChar = 'a';
                int minFreq = Integer.MAX_VALUE;

                for (int j = 0; j < 26; j++) {
                    if (minFreq > freq[j]) {
                        minFreq = freq[j];
                        minChar = (char) (97 + j);
                    }
                }

                sb.append(minChar);
                freq[minChar - 'a']++;
            }
        }

        char[] chs = sb.toString().toCharArray();
        Arrays.sort(chs);
        int k = 0;
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '?') {
                ans.append(chs[k++]);
            } else {
                ans.append(ch);
            }
        }

        return ans.toString();
    }
}
