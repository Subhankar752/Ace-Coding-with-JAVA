class Solution {
    public int countEven(int num) {
        int ans = 0;
        for(int i = 2 ; i <= num ; i++){
            if(solve(i) == true)
                ans++;
        }
        return ans;
    }
    public boolean solve(int n){
        int c = 0;
        while(n != 0){
            int r = n % 10;
            c += r;
            n = n/10;
        }
        if(c % 2 == 0)
            return true;
        return false;
    }
}