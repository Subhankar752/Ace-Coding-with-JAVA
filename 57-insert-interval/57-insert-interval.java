class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<List<Integer>>res = new ArrayList<>();
        for(int i=0;i<intervals.length;i++){
            if(newInterval[1]<intervals[i][0]){//no merge required
                res.add(new ArrayList<>(Arrays.asList(intervals[i][0],intervals[i][1])));
            }else if(newInterval[0]>intervals[i][1]){//no merge required
                res.add(new ArrayList<>(Arrays.asList(intervals[i][0],intervals[i][1])));
            }else{//update interval
                newInterval[0] =  Math.min(newInterval[0],intervals[i][0]);
                newInterval[1]  = Math.max(newInterval[1],intervals[i][1]);
            }
        }
        res.add(new ArrayList<>(Arrays.asList(newInterval[0],newInterval[1])));//add the interval
        int result[][]=new int[res.size()][2];
        for(int i=0;i<res.size();i++){
            result[i][0]=res.get(i).get(0);
            result[i][1]=res.get(i).get(1);
        }
        Arrays.sort(result,(a,b)->(a[0]-b[0]));//sort in asc after merging all intervals based on 0th index
        return result;
    }
}