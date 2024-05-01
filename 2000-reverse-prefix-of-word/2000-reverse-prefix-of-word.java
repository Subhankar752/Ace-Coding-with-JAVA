class Solution {

    public String reversePrefix(String word, char ch) {
        int idx = -1;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == ch) {
                idx = i;
                break;
            }
        }

        StringBuilder sb = new StringBuilder(word.substring(0, idx + 1));
        sb.reverse();
        sb.append(word.substring(idx + 1));

        return sb.toString();
    }
}
