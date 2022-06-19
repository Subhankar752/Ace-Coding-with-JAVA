class Solution {
    public String greatestLetter(String s) {
        HashSet<Character> hs = new HashSet<>();
        for(char c : s.toCharArray())
            hs.add(c);
        for(char i = 'z' ; i >= 'a' ; i--){
            char upper = Character.toUpperCase(i);
            if(hs.contains(i) && hs.contains(upper))
                return "" + upper;
        }
        return ""; 
        
    }
}