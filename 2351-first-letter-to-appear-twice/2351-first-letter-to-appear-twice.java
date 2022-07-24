class Solution {
    public char repeatedCharacter(String s) {
        HashSet<Character> hs = new HashSet<>();
        for(char c : s.toCharArray()){
            if(hs.contains(c))
                return c;
            hs.add(c);
        }
        return 'x';
    }
}