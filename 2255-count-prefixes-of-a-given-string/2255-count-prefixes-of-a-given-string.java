class Solution {
    public int countPrefixes(String[] words, String s) {
        int ans = 0;
        for(String st : words){
            if(s.startsWith(st))
                ans++;
        }
        return ans;
    }
}