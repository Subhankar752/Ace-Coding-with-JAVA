class Solution {
    public int maximumCandies(int[] a, long k) {
        int ans = 0;
        int low = 0;
        int high = Integer.MAX_VALUE;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(solve(mid , a , k) == true){
                ans = mid;
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return ans;
    }
    public boolean solve(int allow , int[] candies , long k){
        if(allow == 0)
            return true;
        long total = 0;
        for(int candy : candies) {
            total += candy / allow;
            if(total >= k)
                return true;
        }
        return false;
    }
}