class Solution {
   String[] codes = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

    public int uniqueMorseRepresentations(String[] words) {
        Set<String> set = new HashSet<>();
        for (String word : words) {
            set.add(getCode(word));
        }
        return set.size();
    }

    private String getCode(String word) {
        StringBuilder sb = new StringBuilder();
        for (char ch : word.toCharArray()) {
            sb.append(codes[ch - 'a']);
        }
        return sb.toString();
    }
}