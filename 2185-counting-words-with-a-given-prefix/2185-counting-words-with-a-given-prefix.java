class Solution {
    public int prefixCount(String[] words, String pref) {
        int n = pref.length();
        int ans = 0;
        for(String s : words){
            int len = s.length();
            if(len < n)
                continue;
            String temp = s.substring(0 , n);
            if(temp.equals(pref))
                ans++;
        }
        return ans;
    }
}