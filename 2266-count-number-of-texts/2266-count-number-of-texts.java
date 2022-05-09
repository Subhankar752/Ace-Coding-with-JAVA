class Solution {
   
    int[] dp;
    int mod = (int)Math.pow(10 , 9) + 7;
    
    public int countTexts(String pressedKeys) {
        int n = pressedKeys.length();
        dp = new int[n];
        Arrays.fill(dp , -1);
        return solve(pressedKeys , 0);
    }
    
    public int solve(String st , int idx){
        if(idx == st.length())
            return 1;
        if(dp[idx] != -1)
            return dp[idx];
        int count = 0;
        for(int i = 0 ; i < 4 ; i++){
            if(i == 3 && st.charAt(idx) != '7' && st.charAt(idx) != '9')
                break;
            if(idx + i >= st.length())
                break;
            if(i != 0){
                if(st.charAt(idx + i) != st.charAt(idx + i - 1))
                    break;
            }
            count += solve(st , idx + i + 1);
            count = count % mod;
        }
        dp[idx] = count;
        return count;
    }
}