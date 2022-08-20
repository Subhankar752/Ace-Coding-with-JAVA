class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        int ans = 0;
        int fuelLeft = startFuel; 
        
        for(int[] station : stations){
            int next = station[0];
            int fuel = station[1];
            
            // fill only if we don't have enough to go to next station
            while(fuelLeft < next){
                if(pq.isEmpty()){
                    return -1;
                }
                int topFuel = pq.poll();
                fuelLeft += topFuel;
                ans++;
            }
            pq.add(fuel);
        }
        
        while(fuelLeft < target){
            if(pq.isEmpty()){
                return -1;
            }
            
            int topFuel = pq.poll();
            fuelLeft += topFuel;
            ans++;
        }
        
        return ans;
    }
}