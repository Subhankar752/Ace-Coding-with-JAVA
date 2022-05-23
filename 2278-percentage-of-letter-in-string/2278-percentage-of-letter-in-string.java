class Solution {
    public int percentageLetter(String s, char letter) {
        int val = 0;
        for(char c : s.toCharArray()){
            if(c == letter)
                val++;
        }
        int n = s.length();
        int per = ((val * 100)/(n));
        System.out.println(per);
        return per;
    }
}