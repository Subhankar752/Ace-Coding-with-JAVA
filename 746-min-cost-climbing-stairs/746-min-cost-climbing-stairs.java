class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int mem[] = new int[cost.length];
        
        Arrays.fill(mem , -1);
        
        return Math.min(solve(cost , 0 , mem), solve(cost , 1 , mem));
    }
    
    public static int solve(int[] cost , int i , int[] mem) {
        
        if(i >= cost.length) {
            return 0;
        }
        
        if(mem[i] != -1) {
            return mem[i];
        }
        
        mem[i] = cost[i] + Math.min(solve(cost , i + 1 , mem) , solve(cost , i + 2 , mem));
       
        return mem[i];
    }
}