class Solution {
    private Map<Character, String> letters = Map.of('2', "abc", '3', "def", '4', "ghi", '5', "jkl", '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
    String res;
    List<String> ans;

    public List<String> letterCombinations(String digits) {
        res = digits;
        ans = new ArrayList<>();

        if (digits.length() == 0) return new ArrayList<>();

        backtrack(0, new StringBuilder());

        return ans;
    }

    public void backtrack(int index, StringBuilder asf) {
        if (asf.length() == res.length()) {
            ans.add(asf.toString());
            return;
        }

        String letter = letters.get(res.charAt(index));

        for (int i = 0; i < letter.length(); i++) {
            char ch = letter.charAt(i);
            asf.append(ch);
            backtrack(index + 1, asf);
            asf.deleteCharAt(asf.length() - 1);
        }
    }
}
