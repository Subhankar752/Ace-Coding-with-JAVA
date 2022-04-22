class Solution {
    public String digitSum(String s, int k) {
        while(s.length() > k){
            String res = "";
            int n = s.length();
            int val = n / k;
            if(n % k != 0)
                val++;
            int i = 0;
            while(i < n){
                String temp = s.substring(i , Math.min(n , i + k));
                i += k;
                temp = solve(temp);
                res += temp;
            }
            s = res;
        }
        return s;
    }
    public String solve(String s){
        int val = 0;
        for(char c : s.toCharArray()){
            int x = c - '0';
            val += x;
        }
        return Integer.toString(val);
    }
}