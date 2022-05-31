class Solution {
    public boolean hasAllCodes(String s, int k) {
        HashSet<String> hs = new HashSet<>();
        int n = s.length();
        for(int i = 0 ; i <= (n - k) ; i++){
            String temp = s.substring(i , i + k);
            hs.add(temp);
        }
        int size = hs.size();
        int res = (int)Math.pow(2 , k);
        return (size == res);
    }
}