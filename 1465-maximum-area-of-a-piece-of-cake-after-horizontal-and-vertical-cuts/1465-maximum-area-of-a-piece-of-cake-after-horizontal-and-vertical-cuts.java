class Solution {
    public int maxArea(int h, int w, int[] horCuts, int[] verCuts) {
        Arrays.sort(horCuts);
        Arrays.sort(verCuts);
        int n1=horCuts.length;
        int n2=verCuts.length;
        int mod=(int)Math.pow(10,9) + 7;
        int max1=Math.max(horCuts[0] , h - horCuts[n1-1]);
        int max2=Math.max(verCuts[0] , w - verCuts[n2-1]);
        for(int i=1;i<n1;i++){
            int c=horCuts[i] - horCuts[i-1];
            max1=Math.max(max1,c);
        }
        for(int i=1;i<n2;i++){
            int c=verCuts[i] - verCuts[i-1];
            max2=Math.max(max2,c);
        }
       long res = ((long)max1*max2) % mod;
       return (int)res;
        
    }
}