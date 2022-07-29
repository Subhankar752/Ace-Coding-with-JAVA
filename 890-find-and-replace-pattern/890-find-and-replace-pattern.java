class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        Integer[] indexp = new Integer[26];
        Integer[] indexw = new Integer[26];
        for (String w : words) {
            boolean valid = true;
            for (int i = 0; i < pattern.length(); i++) {
                int inp = pattern.charAt(i) - 'a';
                int inw = w.charAt(i) - 'a';
                if (indexp[inp] != indexw[inw]) {
                    valid = false;
                    break;
                }
                indexp[inp] = inp;
                indexw[inw] = inp;
            }
            if(valid)
                res.add(w);
            Arrays.fill(indexp, null);
            Arrays.fill(indexw, null);
        }
        return res;
    }
}