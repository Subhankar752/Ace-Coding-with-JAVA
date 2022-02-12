class Solution {
    public boolean isPalindrome(int x) {
        int p=x;
        int sum=0;
        while(x>0){
            int r=x%10;
            sum=sum*10+r;
            x=x/10;
        }
        return (sum == p);
    }
}