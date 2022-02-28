class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long a = 0;
        long max = 0;
        for(int i:time){
            max = Math.max(max,(long)i);
        }
        for(int i:time){
            a+=max/i;
        }
        long low = 1;
        long high = ((totalTrips / a)+1) * max;
        while(low < high){
            long mid = low + (high-low)/2;
            long trips = totalTrips(mid, time);
            if(trips < totalTrips) low = mid+1;
            else high = mid;
        }
        return low;
        
    }
    public long totalTrips(long s, int[] time){
        long ans = 0;
        for(long i:time){
            ans+=s/i;
        }
        
        return ans;
        
    }
}