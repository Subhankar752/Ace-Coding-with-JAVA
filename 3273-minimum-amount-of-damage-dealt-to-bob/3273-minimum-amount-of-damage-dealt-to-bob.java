class Solution {
    
    class Pair {
        int d;
        int h;
        int t;
        double dt;
        
        Pair (int d, int h, int t, double dt) {
            this.d = d;
            this.h = h;
            this.t = t;
            this.dt = dt;
        }
        
        public String toString() {
            return "" + d + "-" + h + "-" + t + "-" + dt;
        }
    }
    
    public long minDamage(int power, int[] damage, int[] health) {
        int n = damage.length;
        Pair[] pair = new Pair[n];
        long total = 0l;
        
        for (int i = 0 ; i < n ; i++) {
            total += damage[i];
            int time = (int) Math.ceil(health[i] * 1.0 / power);
            double dt = damage[i] * 1.0 / time;
            pair[i] = new Pair(damage[i], health[i], time, dt);
        }
        
        Arrays.sort(pair, (a, b) -> a.dt == b.dt ? a.t - b.t : Double.compare(b.dt, a.dt));
        
        long ans = 0l;
        for (int i = 0 ; i < n ; i++) {
            Pair p = pair[i];
            ans += total * p.t;
            total -= p.d;
        }
        
        return ans;
    }
}