class Solution {
    public int findNumbers(int[] nums) {
        int ans = 0;
        for(int i : nums){
            if(check(i) == true)
                ans++;
        }
        return ans;
    }
    public boolean check(int n){
        int c = 0;
        while(n > 0){
            c++;
            n = n / 10;
        }
        if(c % 2 == 0)
            return true;
        return false;
    }
}