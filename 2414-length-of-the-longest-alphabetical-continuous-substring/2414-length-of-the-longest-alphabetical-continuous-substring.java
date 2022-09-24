class Solution {
    public int longestContinuousSubstring(String s) {
        int ans = 1;
        s += "#";
        int n = s.length();
        int i = 0;
        while(i < n - 1){
            int prev = i;
            int j = i + 1;
            while(j < n){
                int v1 = s.charAt(prev);
                int v2 = s.charAt(j);
                if(v1 + 1 == v2){
                    prev = j;
                    j++;
                }
                else{
                    break;
                }
            }
            ans = Math.max(ans , j - i);
            i = j;
        }
        return ans;
    }
}