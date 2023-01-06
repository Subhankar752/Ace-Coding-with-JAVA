class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);

        int len = costs.length;
        int val = 0;
        int i = 0;

        while(val + costs[i] <= coins && i < len){
            val = val + costs[i];
            i++;
            if(i == len)break;
        }
        
        return i;
    }
}