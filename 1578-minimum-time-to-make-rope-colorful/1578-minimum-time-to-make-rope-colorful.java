class Solution {
    public int minCost(String colors, int[] neededTime) {
        int ans = 0;
        
        for(int i = 0 ; i < colors.length() - 1 ; i++)
        {
            if(colors.charAt(i) == colors.charAt(i + 1))
            {
                int min = Math.min(neededTime[i] , neededTime[i + 1]);
                ans += min;
        
                if(neededTime[i] == min)
                {
                    neededTime[i] = neededTime[i + 1];
                }
                else
                {
                    neededTime[i + 1] = neededTime[i];
                }
            }
        }
        
        return ans;
    }
}