class Solution {
    public int carFleet(int target, int[] position, int[] speed) { 
        int ans = 1, n = position.length;
        car [] cars = new car[n];
        for (int i = 0; i<n; i++) {
            cars[i] = new car(position[i], speed[i]);
        }
        Arrays.sort(cars);
        car lst = null;
        for (int i = n-1; i>=0; i--) {
            if (lst==null) lst = cars[i];
            else {
                if (!catchup(lst, cars[i], target)) {
                    lst = cars[i];
                    ans++;
                }
            }
        }      
        return ans;
    }
    // true if second car can catch up to first car
    public boolean catchup(car fir, car sec, int dest) {
        double t = (dest-fir.pos)/fir.v;
        if (sec.pos + t*sec.v >= dest) {
            return true;
        }
        else return false;
    }
    public class car implements Comparable<car>{
        double pos, v;
        car(int i, int speed) { pos = (double) i; v = speed; }
        public int compareTo(car nxt) {
            return Double.compare(pos, nxt.pos);
        }
    }
}