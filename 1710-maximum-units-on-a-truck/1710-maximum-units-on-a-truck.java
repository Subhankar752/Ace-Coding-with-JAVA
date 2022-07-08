class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        
        Arrays.sort(boxTypes , (aa , bb) -> bb[1] - aa[1]);
       
        int ans = 0;
        
        for(int[] i : boxTypes){
            
            int box = i[0];
            int units = i[1];
            
            int min = Math.min(truckSize , box);
            
            truckSize -= min;
            ans += min * units;
            
        }
        
        return ans;
    }
}