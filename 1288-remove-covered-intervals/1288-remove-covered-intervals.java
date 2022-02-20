class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->a[0]==b[0]?b[1]-a[1]:a[0]-b[0]);
        int ans=intervals.length;
        int max=intervals[0][1];
        ans=1;
        for(int[] a:intervals)
        {
            if(a[1]>max)
            {
                ans++;
                max=a[1];
            }
        }
        return ans;
    }
}