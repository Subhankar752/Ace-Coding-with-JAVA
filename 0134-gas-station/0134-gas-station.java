class Solution {
   public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int need = cost[n - 1];
        int tank = gas[0], station = 0;
       
        for (int i = 1; i < n; i++) {
            tank = tank - cost[i - 1];
            
            if (tank < 0) {
                need += Math.abs(tank);
                tank = gas[i];
                station = i;
            } else {
                tank += gas[i];
            }

        }

        return tank >= need ? station : -1;
    }
    public int solve(int i , int[] p , int[] d , int n){
        int j=i;
        int sum=0;
        while(true){
            sum+=(p[i] - d[i]);
            if(sum < 0)
            return -1;
            i++;
            i=i%n;
            if(i == j)
            return j;
        }
    }
}