class Solution {
    public int maxPerformance(int ni, int[] speed, int[] efficiency, int k) {
        if(ni==0 || k==0)return 0;
        int[][] play = new int[ni][2];
        for (int i=0; i<ni; i++)
        {
            play[i][0] = efficiency[i];
            play[i][1] = speed[i];
        }
        Arrays.sort(play, (p1, p2) -> (p2[0] - p1[0]));
        PriorityQueue<Integer> speedQueue = new PriorityQueue<>(k);
        long teamPerformance = 0, teamSpeed = 0;
        for (int i=0; i<ni; i++){
            if (speedQueue.size() >= k){
                teamSpeed =teamSpeed- speedQueue.remove();
            }
            speedQueue.add(play[i][1]);
            teamSpeed =teamSpeed + play[i][1];
            teamPerformance = Math.max(teamPerformance, teamSpeed * play[i][0]);
        }
        return (int) (teamPerformance % 1000000007);
    }
}