class Solution {

    class Pair {
        int ptime;
        int gtime;

        Pair(int ptime, int gtime) {
            this.ptime = ptime;
            this.gtime = gtime;
        }
    }

    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n = plantTime.length;

        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Pair(plantTime[i], growTime[i]));
        }

        Collections.sort(list, (a, b) -> b.gtime - a.gtime);

        int maxTime = Integer.MIN_VALUE;
        int curTime = 0;

        for (Pair p : list) {
            int ptime = p.ptime;
            int gtime = p.gtime;

            curTime += ptime;
            maxTime = Math.max(curTime + gtime, maxTime);
        }

        return maxTime;
    }
}
