class Solution {
    public String getSmallestString(int n, int k) {
        char[] a = new char[n];
        for(int i = n - 1 ; i >= 0 ; i--){
            if(k - i >= 26){
                a[i] = 'z';
                k -= 26;
            }
            else{
                int val = k - i + 96;
                a[i] = (char)val;
                k = i;
            }
        }
        String ans = new String(a);
        return ans;
    }
}